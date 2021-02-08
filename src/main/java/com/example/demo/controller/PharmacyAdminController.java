package com.example.demo.controller;

import com.example.demo.dto.PharmacyAdminDTO;
import com.example.demo.model.PharmacyAdmin;
import com.example.demo.service.PharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/pharmacyAdmins", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyAdminController {

    private final PharmacyAdminService pharmacyAdminService;

    @Autowired
    public PharmacyAdminController(PharmacyAdminService pharmacyAdminService) {
        this.pharmacyAdminService = pharmacyAdminService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PharmacyAdminDTO>> findAll() {
        List<PharmacyAdmin> pharmacyAdmins = pharmacyAdminService.findAll();

        List<PharmacyAdminDTO> pharmacyAdminDTOs = new ArrayList<>();
        for(PharmacyAdmin pA : pharmacyAdmins){
            pharmacyAdminDTOs.add(new PharmacyAdminDTO(pA));
        }
        return new ResponseEntity<>(pharmacyAdminDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PharmacyAdminDTO> getPharmacyAdmin(@PathVariable Long id) {

        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findOne(id);

        if (pharmacyAdmin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new PharmacyAdminDTO(pharmacyAdmin), HttpStatus.OK);
    }


}
