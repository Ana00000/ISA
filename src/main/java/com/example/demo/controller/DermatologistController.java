package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.DermatologistDTO;
import com.example.demo.model.Dermatologist;
import com.example.demo.service.DermatologistService;

@RestController
@RequestMapping(value = "/dermatologists", produces = MediaType.APPLICATION_JSON_VALUE)
public class DermatologistController {
	
	private DermatologistService dermatologistService;
    
	@Autowired
	public DermatologistController(DermatologistService dermatologistService) {
		this.dermatologistService = dermatologistService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<DermatologistDTO>> getAllDermatologists() {

		List<Dermatologist> dermatologists = dermatologistService.findAll();

		List<DermatologistDTO> dermatologistsDTO = new ArrayList<>();
		for (Dermatologist d : dermatologists) {
			dermatologistsDTO.add(new DermatologistDTO(d));
		}

		return new ResponseEntity<>(dermatologistsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DermatologistDTO> getDermatologist(@PathVariable Long id) {

		Dermatologist dermatologist = dermatologistService.findOne(id);

		if (dermatologist == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new DermatologistDTO(dermatologist), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDermatologist(@PathVariable Long id) {

		Dermatologist dermatologist = dermatologistService.findOne(id);

		if (dermatologist != null) {
			dermatologistService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}