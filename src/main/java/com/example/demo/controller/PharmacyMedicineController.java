package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MedicineIngredientDTO;
import com.example.demo.dto.PharmacyMedicineDTO;
import com.example.demo.model.MedicineIngredient;
import com.example.demo.model.PharmacyMedicine;
import com.example.demo.service.MedicineService;
import com.example.demo.service.PharmacyMedicineService;
import com.example.demo.service.PharmacyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/pharmacyMedicines", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyMedicineController {

    private PharmacyMedicineService pharmacyMedicineService;
    private MedicineService medicineService;
    private PharmacyService pharmacyService;
    
	@Autowired
    public PharmacyMedicineController(PharmacyMedicineService pharmacyMedicineService,
    		MedicineService medicineService, PharmacyService pharmacyService) {
        this.pharmacyMedicineService = pharmacyMedicineService;
        this.medicineService = medicineService;
        this.pharmacyService = pharmacyService;
    }
	
	@GetMapping(value = "/all")
    public ResponseEntity<List<PharmacyMedicineDTO>> getAllPharmacyMedicines() {

        List<PharmacyMedicine> pharmacyMedicines = pharmacyMedicineService.findAll();

		List<PharmacyMedicineDTO> pharmacyMedicineDTO = new ArrayList<>();
		for (PharmacyMedicine pm : pharmacyMedicines) {
			pharmacyMedicineDTO.add(new PharmacyMedicineDTO(pm));
		}

		return new ResponseEntity<>(pharmacyMedicineDTO, HttpStatus.OK);
    }
	/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<PharmacyMedicineDTO> getPharmacyMedicine(@PathVariable Long id) {

		PharmacyMedicine pharmacyMedicine = pharmacyMedicineService.findOne(id);

		if (pharmacyMedicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new PharmacyMedicineDTO(pharmacyMedicine), HttpStatus.OK);
	}
	
	@GetMapping(value = "/findPharmacyMedicineByMedicine/{id}")
    public ResponseEntity<PharmacyMedicine> getPharmacyMedicineByMedicine(@PathVariable Long id) {

    	PharmacyMedicine pharmacyMedicine = pharmacyMedicineService.findByMedicineId(id);
        
        return new ResponseEntity<>( pharmacyMedicine, HttpStatus.OK );
	}

    @GetMapping(value = {"/pharmacyMedicineByMedicineAndPharmacy/{pharmacy_id}", "/{medicine_id}"})
    public ResponseEntity<PharmacyMedicine> getPharmacyMedicineByMedicineAndPharmacy(@PathVariable("medicine_id") Long medicine_id, @PathVariable("pharmacy_id") Long pharmacy_id) {

    	PharmacyMedicine pharmacyMedicine = pharmacyMedicineService.findByMedicineAndPharmacy(
    			medicineService.findOne(medicine_id), pharmacyService.findOne(pharmacy_id));
        
        return new ResponseEntity<>( pharmacyMedicine, HttpStatus.OK );
	}*/
	
}