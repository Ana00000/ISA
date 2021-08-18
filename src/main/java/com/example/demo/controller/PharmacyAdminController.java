package com.example.demo.controller;

import com.example.demo.dto.PharmacyAdminDTO;
import com.example.demo.dto.PharmacyDTO;
import com.example.demo.model.PharmacyAdmin;
import com.example.demo.service.DermatologistService;
import com.example.demo.service.PharmacyAdminService;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pharmacyAdmins", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyAdminController {

    private final PharmacyAdminService pharmacyAdminService;
    private final PharmacyService pharmacyService;
    private final DermatologistService dermatologistService;

    @Autowired
    public PharmacyAdminController(PharmacyAdminService pharmacyAdminService, PharmacyService pharmacyService,
                                   DermatologistService dermatologistService) {
        this.pharmacyAdminService = pharmacyAdminService;
        this.pharmacyService = pharmacyService;
        this.dermatologistService = dermatologistService;
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

    @GetMapping("/findLoggedPharmacyAdmin")
    public ResponseEntity<PharmacyAdminDTO> findLoggedPharmacyAdmin(Authentication authentication) {

        System.out.println("User: " + authentication.getName());

        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findOneByEmail(authentication.getName());

        if (pharmacyAdmin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PharmacyAdminDTO pharmacyAdminDTO = new PharmacyAdminDTO(pharmacyAdmin);
        return new ResponseEntity<>(pharmacyAdminDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PharmacyAdminDTO> getPharmacyAdmin(@PathVariable Long id) {

        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findOne(id);

        if (pharmacyAdmin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new PharmacyAdminDTO(pharmacyAdmin), HttpStatus.OK);
    }

    @PostMapping(value = "addPharmacyAdmin")
    public ResponseEntity<PharmacyAdminDTO> addPharmacyAdmin(@RequestBody PharmacyAdminDTO pharmacyAdminDTO){
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.addPharmacyAdmin(pharmacyAdminDTO);
        return new ResponseEntity<>(pharmacyAdminDTO,HttpStatus.CREATED);
    }
}
