package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AllergyDTO;
import com.example.demo.model.Allergy;
import com.example.demo.service.AllergyService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/allergies", produces = MediaType.APPLICATION_JSON_VALUE)
public class AllergyController {
	
	private AllergyService allergyService;
    
	@Autowired
	public AllergyController(AllergyService allergyService) {
		this.allergyService = allergyService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AllergyDTO>> getAllAllergies() {

		List<Allergy> allergies = allergyService.findAll();

		List<AllergyDTO> allergiesDTO = new ArrayList<>();
		for (Allergy a : allergies) {
			allergiesDTO.add(new AllergyDTO(a));
		}

		return new ResponseEntity<>(allergiesDTO, HttpStatus.OK);
	}
}
