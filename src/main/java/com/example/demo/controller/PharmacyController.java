package com.example.demo.controller;

import com.example.demo.dto.Hadzi.PharmacyDTOHadzi;
import com.example.demo.dto.PharmacyDTO;
import com.example.demo.model.*;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/pharmacies", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {

    private final PharmacyService pharmacyService;
    private final AppointmentService appointmentService;
    private final MedicineReservationService medicineReservationService;
    private final MedicinePrescriptionService medicinePrescriptionService;
    private final PatientService patientService;
    private final MedicineService medicineService;
    private final PharmacyMedicineService pharmacyMedicineService;
    private final TokenUtils tokenUtils;
    
	@Autowired
    public PharmacyController(PharmacyService pharmacyService, AppointmentService appointmentService,
                              MedicineReservationService medicineReservationService, MedicinePrescriptionService medicinePrescriptionService,
                              PatientService patientService, MedicineService medicineService, PharmacyMedicineService pharmacyMedicineService, TokenUtils tokenUtils) {
        this.pharmacyService = pharmacyService;
        this.appointmentService = appointmentService;
        this.medicineReservationService = medicineReservationService;
        this.medicinePrescriptionService = medicinePrescriptionService;
        this.patientService = patientService;
        this.medicineService = medicineService;
        this.pharmacyMedicineService = pharmacyMedicineService;
        this.tokenUtils = tokenUtils;
    }

    @PostMapping(value = "/addPharmacy")
    public ResponseEntity<Pharmacy> addPharmacy(@RequestBody PharmacyDTO pharmacyDTO){
	    pharmacyDTO.setAverageGrade(0);
	    Pharmacy pharmacy = new Pharmacy(pharmacyDTO);
        pharmacyService.save(pharmacy);
	    return new ResponseEntity<>(pharmacy,HttpStatus.CREATED);
    }

    @GetMapping(value = "/allHadzi")
    public ResponseEntity<List<PharmacyDTOHadzi>> getAllPharmaciesHadzi() {

        List<Pharmacy> pharmacies = pharmacyService.findAll();

        List<PharmacyDTOHadzi> pharmacistsDTO = new ArrayList<>();
        for (Pharmacy p : pharmacies) {
            pharmacistsDTO.add(new PharmacyDTOHadzi(p));
        }
        
        return new ResponseEntity<>(pharmacistsDTO, HttpStatus.OK);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<PharmacyDTO>> getAllPharmacies() {

        List<Pharmacy> pharmacies = pharmacyService.findAll();

        List<PharmacyDTO> pharmacistsDTO = new ArrayList<>();
        for (Pharmacy p : pharmacies) {
            pharmacistsDTO.add(new PharmacyDTO(p));
        }
        
        return new ResponseEntity<>(pharmacistsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/allSubscribed")
    public ResponseEntity<List<PharmacyDTO>> getAllSubscribedPharmacies(Authentication authentication) {
        Patient patient = patientService.findOneByEmail(authentication.getName());
        Set<Pharmacy> pharmacies = patient.getPharmacieSubscribed();

        List<PharmacyDTO> pharmacistsDTO = new ArrayList<>();
        for (Pharmacy p : pharmacies) {
            pharmacistsDTO.add(new PharmacyDTO(p));
        }

        return new ResponseEntity<>(pharmacistsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getPharmacyThatHaveMedicin/{id}")
    public ResponseEntity<List<PharmacyDTO>> getPharmacyThatHaveMedicin(@PathVariable Long id){
	    Medicine medicine = medicineService.findOne(id);
        List<Pharmacy> pharmacies = new ArrayList<>();
        List<PharmacyMedicine> pharmacyMedicines = pharmacyMedicineService.findAllByMedicineId(id);
	    for(PharmacyMedicine pm : pharmacyMedicines){
	        pharmacies.add(pm.getPharmacy());
        }

        List<PharmacyDTO> pharmacyDTOS = new ArrayList<>();



        for(Pharmacy p : pharmacies){
            pharmacyDTOS.add(new PharmacyDTO(p));
        }
        return new ResponseEntity<>(pharmacyDTOS,HttpStatus.OK);
    }

    @GetMapping(value = "/allUserIsNotSubscribedOn")
    public ResponseEntity<List<PharmacyDTO>> getAllUserIsNotSubscribedOnPharmacies(Authentication authentication) {
        Patient patient = patientService.findOneByEmail(authentication.getName());
        Set<Pharmacy> pharmaciesSub = patient.getPharmacieSubscribed();
        List<Pharmacy> pharmaciesNotSub = new ArrayList<>();
        boolean itIsFounded= false;
        for(Pharmacy p :pharmacyService.findAll()){
            itIsFounded=false;
            for(Pharmacy ps :pharmaciesSub){
                if(ps.getId() == p.getId()){
                    itIsFounded= true;
                    break;
                }
            }
            if(!itIsFounded){
                pharmaciesNotSub.add(p);
            }

        }


        List<PharmacyDTO> pharmacistsDTO = new ArrayList<>();
        for (Pharmacy p : pharmaciesNotSub) {
            pharmacistsDTO.add(new PharmacyDTO(p));
        }

        return new ResponseEntity<>(pharmacistsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PharmacyDTO> getPharmacy(@PathVariable Long id) {

        Pharmacy pharmacy = pharmacyService.findOne(id);

        if (pharmacy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new PharmacyDTO(pharmacy), HttpStatus.OK);
    }
    
    @GetMapping(value = "/pharmacyByAppointment/{id}")
    public ResponseEntity<PharmacyDTO> getPharmacyByAppointment(@PathVariable Long id) {
    	
    	Appointment appointment = appointmentService.findOne(id);
    	Pharmacy pharmacy = null;
		for(Pharmacy p : pharmacyService.findAll()) 
			if(p.getAppointments().contains(appointment)) 
				pharmacy = p;
			
		return new ResponseEntity<>(new PharmacyDTO(pharmacy), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePharmacy(@PathVariable Long id) {

        Pharmacy pharmacy = pharmacyService.findOne(id);

        if (pharmacy != null) {
            pharmacyService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/test/{id}")
    public ResponseEntity<List<PharmacyDTOHadzi>> getPharmaciesByDermatologist(@PathVariable Long id) {

        List<Pharmacy> pharmacies = pharmacyService.findAllPharmaciesByDermatologist(id);
        List<PharmacyDTOHadzi> pharmaciesDTO = new ArrayList<>();
        for(Pharmacy p : pharmacies){
            pharmaciesDTO.add(new PharmacyDTOHadzi(p));
        }
        return new ResponseEntity<>( pharmaciesDTO, HttpStatus.OK );
	}

    @GetMapping(value = "/patient")
    public ResponseEntity<List<PharmacyDTOHadzi>> getAllByPatient(HttpServletRequest request) {
        String token = tokenUtils.getToken(request);
        if( token == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String username = tokenUtils.getUsernameFromToken(token);
        Patient patient = patientService.findOneByEmail(username);

        List<Pharmacy> pharmacies = pharmacyService.findAll();
        List<MedicineReservation> medicineReservations = medicineReservationService.findAllByPatient(patient);
        List<MedicinePrescription> medicinePrescriptions = medicinePrescriptionService.findAllByPatient(patient);
        List<Appointment> appointments = appointmentService.findAllByPatient(patient);

        List<PharmacyDTOHadzi> pharmacistsDTO = new ArrayList<>();
        for (Pharmacy p : pharmacies) {
//            boolean shouldAdd = false;
//            for(MedicineReservation mr : medicineReservations){
//                if(mr.getPharmacy().getId() == p.getId()){
//                    shouldAdd = true;
//                    break;
//                }
//            }
            pharmacistsDTO.add(new PharmacyDTOHadzi(p));
        }

        return new ResponseEntity<>(pharmacistsDTO, HttpStatus.OK);
    }
}
