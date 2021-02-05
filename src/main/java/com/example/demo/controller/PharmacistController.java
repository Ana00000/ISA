package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PharmacistDTO;
import com.example.demo.model.Pharmacist;
import com.example.demo.service.PharmacistService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/pharmacists", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacistController {
	
	private final PharmacistService pharmacistService;
    
	@Autowired
	public PharmacistController(PharmacistService pharmacistService) {
		this.pharmacistService = pharmacistService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<PharmacistDTO>> getAllPharmacists() {

		List<Pharmacist> pharmacists = pharmacistService.findAll();

		List<PharmacistDTO> pharmacistsDTO = new ArrayList<>();
		for (Pharmacist p : pharmacists) {
			pharmacistsDTO.add(new PharmacistDTO(p));
		}

		return new ResponseEntity<>(pharmacistsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PharmacistDTO> getPharmacist(@PathVariable Long id) {

		Pharmacist pharmacist = pharmacistService.findOne(id);

		if (pharmacist == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new PharmacistDTO(pharmacist), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePharmacist(@PathVariable Long id) {

		Pharmacist pharmacist = pharmacistService.findOne(id);

		if (pharmacist != null) {
			pharmacistService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}