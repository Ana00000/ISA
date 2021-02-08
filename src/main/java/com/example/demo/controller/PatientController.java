package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.http.MediaType;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
	
	private PatientService patientService;
    
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
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
}
