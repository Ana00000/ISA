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
import com.example.demo.model.Appointment;
import com.example.demo.model.Pharmacy;
import com.example.demo.service.PharmacyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/pharmacies", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {

    private PharmacyService pharmacyService;
    
	@Autowired
    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
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

    	Pharmacy pharmacy = null;
		for(Pharmacy p : pharmacyService.findAll())
			for(Appointment a : p.getAppointments())
				if(a.getId() == id)
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
}
