package com.example.demo.controller;

import com.example.demo.dto.PharmacistDTO;
import com.example.demo.dto.PharmacyDTO;
import com.example.demo.model.Pharmacist;
import com.example.demo.model.Pharmacy;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pharmacies", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {

    private PharmacyService pharmacyService;

    @Autowired
    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PharmacyDTO>> getAllPharmacists() {

        List<Pharmacy> pharmacies = pharmacyService.findAll();

        List<PharmacyDTO> pharmacistsDTO = new ArrayList<>();
        for (Pharmacy p : pharmacies) {
            pharmacistsDTO.add(new PharmacyDTO(p));
        }

        return new ResponseEntity<>(pharmacistsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PharmacyDTO> getPharmacist(@PathVariable Long id) {

        Pharmacy pharmacy = pharmacyService.findOne(id);

        if (pharmacy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new PharmacyDTO(pharmacy), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePharmacist(@PathVariable Long id) {

        Pharmacy pharmacy = pharmacyService.findOne(id);

        if (pharmacy != null) {
            pharmacyService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
