package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PharmacyDTO;
import com.example.demo.dto.Hadzi.PharmacyDTOHadzi;
import com.example.demo.model.Appointment;
import com.example.demo.model.Pharmacy;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.PharmacyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/pharmacies", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {

    private PharmacyService pharmacyService;
    private AppointmentService appointmentService;
    
	@Autowired
    public PharmacyController(PharmacyService pharmacyService, AppointmentService appointmentService) {
        this.pharmacyService = pharmacyService;
        this.appointmentService = appointmentService;
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
}
