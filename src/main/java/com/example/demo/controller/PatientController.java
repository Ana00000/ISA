package com.example.demo.controller;

import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.PromotionDTO;
import com.example.demo.model.Patient;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Promotion;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.PatientService;
import com.example.demo.service.PharmacyService;
import com.example.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
	@Autowired
	private TokenUtils tokenUtils;
	
	private PatientService patientService;
	private PromotionService promotionService;
	private PharmacyService pharmacyService;
    
	@Autowired
	public PatientController(TokenUtils tokenUtils, PatientService patientService, PromotionService promotionService, PharmacyService pharmacyService) {
		this.tokenUtils = tokenUtils;
		this.patientService = patientService;
		this.promotionService = promotionService;
		this.pharmacyService = pharmacyService;
	}
	
	@GetMapping(value = "/allPatients")
	//@PreAuthorize("hasRole('ADMIN')")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<PatientDTO>> getAllPatients(Authentication authentication) {
		
		System.out.println(authentication.getName());
		List<Patient> patients = patientService.findAll();

		List<PatientDTO> patientDTO = new ArrayList<>();
		for (Patient p : patients) {
			patientDTO.add(new PatientDTO(p));
		}

		return new ResponseEntity<>(patientDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	//@PreAuthorize("hasRole('ADMIN')")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<PatientDTO>> getAllPatients() {

		List<Patient> patients = patientService.findAll();

		List<PatientDTO> patientDTO = new ArrayList<>();
		for (Patient p : patients) {
			patientDTO.add(new PatientDTO(p));
		}

		return new ResponseEntity<>(patientDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PatientDTO> getAllPatients(@PathVariable Long id) {

		Patient patient = patientService.findOne(id);

		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new PatientDTO(patient), HttpStatus.OK);
	}

	@GetMapping(value = "/getInfo")
	public ResponseEntity<PatientDTO> getInfo(HttpServletRequest request) {
		//extract patient from session
		String token = tokenUtils.getToken(request);
		if( token == null ){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String username = tokenUtils.getUsernameFromToken(token);
		Patient patient = patientService.findOneByEmail(username);

		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new PatientDTO(patient), HttpStatus.OK);
	}

	@GetMapping(value = "/getPromotions")
	public ResponseEntity<Set<PromotionDTO>> getPromotions(Authentication authentication) {

		//extract patient from session

		Patient patient = patientService.findOneByEmail(authentication.getName());

		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Set<PromotionDTO> promotionDTOS = new HashSet<>();
		for( Pharmacy ph : patient.getPharmacieSubscribed()){
			List<Promotion> promotions = promotionService.findAllByPharmacyId(ph.getId());
			for(Promotion p :promotions){
				promotionDTOS.add(new PromotionDTO(p));
			}
		}

		return new ResponseEntity<>(promotionDTOS, HttpStatus.OK);
	}

	@PostMapping(value = "/subscribeToPharmacyPromotionsByPharmacyId/{id}")
	public ResponseEntity<String> subscribeToPharmacyPromotionsByPharmacyId(Authentication authentication,@PathVariable long id){
		Patient patient = patientService.findOneByEmail(authentication.getName());
		if(patient== null){
			return new ResponseEntity<>("No user found",HttpStatus.BAD_REQUEST);
		}
		Set<Pharmacy> pharmacieSubscribed = patient.getPharmacieSubscribed();
		Pharmacy pharmacy = pharmacyService.findOne(id);
		for(Pharmacy p :pharmacieSubscribed){
			if(p.getId() == id){
				return new ResponseEntity<>("Already subscribed",HttpStatus.OK);
			}
		}
		pharmacieSubscribed.add(pharmacy);
		patient.setPharmacieSubscribed(pharmacieSubscribed);
		patientService.save(patient);

		return new ResponseEntity<>("Successfully subscribed",HttpStatus.CREATED);
	}

	@PostMapping(value = "/usubscribeToPharmacyPromotionsByPharmacyId/{id}")
	public ResponseEntity<String> usubscribeToPharmacyPromotionsByPharmacyId(Authentication authentication,@PathVariable long id){
		Patient patient = patientService.findOneByEmail(authentication.getName());
		if(patient== null){
			return new ResponseEntity<>("No user found",HttpStatus.BAD_REQUEST);
		}
		Set<Pharmacy> pharmacieSubscribed = patient.getPharmacieSubscribed();
		for(Pharmacy p :pharmacieSubscribed){
			if(p.getId() == id){
				pharmacieSubscribed.remove(p);
				break;
			}
		}
		patient.setPharmacieSubscribed(pharmacieSubscribed);
		patientService.save(patient);

		return new ResponseEntity<>("Successfully unsubscribed",HttpStatus.CREATED);
	}
	
	// For this search is needed full name
	@GetMapping(value = "findByName/{name}")
	public ResponseEntity<List<PatientDTO>> getPatientsByName(@PathVariable String name) {

		List<Patient> patients = patientService.findAllByName(name);

		List<PatientDTO> patientsDTO = new ArrayList<>();
		for (Patient p : patients) {
			patientsDTO.add(new PatientDTO(p));
		}
		return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
	}

	// For this search is needed full lastName
	@GetMapping(value = "findByLastName/{lastName}")
	public ResponseEntity<List<PatientDTO>> getPatientsByLastName(@PathVariable String lastName) {

		List<Patient> patients = patientService.findAllByLastName(lastName);

		List<PatientDTO> patientsDTO = new ArrayList<>();
		for (Patient p : patients) {
			patientsDTO.add(new PatientDTO(p));
		}
		return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
	}
	
	// For this search is needed full name and full lastName
	@GetMapping(value = "findByNameAndLastName/{name}/{lastName}")
	public ResponseEntity<List<PatientDTO>> getPatientsByNameAndLastName(@PathVariable("name") String name,
			@PathVariable("lastName") String lastName) {

		List<Patient> patients = patientService.findByNameAndLastNameAllIgnoringCase(name, lastName);

		List<PatientDTO> patientsDTO = new ArrayList<>();
		for (Patient p : patients) {
			patientsDTO.add(new PatientDTO(p));
		}
		return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
	}

	@PostMapping(value="/update")
	public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO PatientDTO) {

		Patient patient = patientService.findOne(PatientDTO.getId());

		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		setOfValidInputs(patient, PatientDTO);
		patient.setActive(PatientDTO.isActive());

		patient = patientService.save(patient);
		return new ResponseEntity<>(new PatientDTO(patient), HttpStatus.OK);
	}
	
	@PutMapping(value="/givePenalty")
	public ResponseEntity<PatientDTO> givePenalty(@RequestBody PatientDTO patientDTO) {

		Patient patient = patientService.findOne(patientDTO.getId());

		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		patient.setId(patientDTO.getId());
		patient.setPenalties(patientDTO.getPenalties()+1);
			
		patient = patientService.save(patient);
		return new ResponseEntity<>(new PatientDTO(patient), HttpStatus.OK);
	}

	private void setOfValidInputs(Patient patient, PatientDTO patientDTO) {
		setOfValidName(patient, patientDTO.getName());
		setOfValidLastName(patient, patientDTO.getLastName());
		setOfValidEmail(patient, patientDTO.getEmail());
		setOfValidPassword(patient, patientDTO.getPassword());
		setOfValidAddress(patient, patientDTO.getAddress());
		setOfValidPhoneNumber(patient, patientDTO.getPhoneNumber());
	}

	private void setOfValidName(Patient patient, String name) {
		if(name.length() < 2)
		{
			System.out.println("Your name should contain at least 2 characters!");
			return;
		}else if(name.length() > 20)
		{
			System.out.println("Your name shouldn't contain more than 20 characters!");
			return;
		}else
			patient.setName(name);
	}

	private void setOfValidLastName(Patient patient, String lastName) {
		if(lastName.length() < 2)
		{
			System.out.println("Your last name should contain at least 2 characters!");
			return;
		}else if(lastName.length() > 20)
		{
			System.out.println("Your last name shouldn't contain more than 20 characters!");
			return;
		}else
			patient.setLastName(lastName);
	}

	private void setOfValidEmail(Patient patient, String email) {
		if(email.length() < 5)
		{
			System.out.println("Your email should contain at least 5 characters!");
			return;
		}else if(email.length() > 35)
		{
			System.out.println("Your email shouldn't contain more than 35 characters!");
			return;
		}else
			patient.setEmail(email);
	}

	private void setOfValidPassword(Patient patient, String password) {
		if(password.length() < 3)
		{
			System.out.println("Your password should contain at least 3 characters!");
			return;
		}else if(password.length() > 20)
		{
			System.out.println("Your password shouldn't contain more than 20 characters!");
			return;
		}else
			patient.setPassword(password);
	}

	private void setOfValidAddress(Patient patient, String address) {
		if(address.length() < 3)
		{
			System.out.println("Your address should contain at least 3 characters!");
			return;
		}else if(address.length() > 50)
		{
			System.out.println("Your address shouldn't contain more than 50 characters!");
			return;
		}else
			patient.setAddress(address);
	}

	private void setOfValidPhoneNumber(Patient patient, String phoneNumber) {
		int flag = validationOfPhoneNumberElements(phoneNumber);
		flag += validationOfPhoneNumberLength(phoneNumber);
		if(flag == 0)
			patient.setPhoneNumber(phoneNumber);
	}

	private int validationOfPhoneNumberElements(String phoneNumber) {
		for(int i = 0; i < phoneNumber.length(); i++)
		{
			if (!(phoneNumber.matches("[0-9]+") || phoneNumber.contains("/") || phoneNumber.contains("-"))) {
				System.out.println("Your phone number can contain only numbers and / - characters!");
				return 1;
			}
		}
		return 0;
	}

	private int validationOfPhoneNumberLength(String phoneNumber) {
		if(phoneNumber.length() < 6)
		{
			System.out.println("Your phone number should contain at least 6 characters!");
			return 1;
		}else if(phoneNumber.length() > 10)
		{
			System.out.println("Your phone number shouldn't contain more than 10 characters!");
			return 1;
		}
		return 0;
	}
}
