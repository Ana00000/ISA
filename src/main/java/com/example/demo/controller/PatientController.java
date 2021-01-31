package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
	
	private PatientService patientService;
    
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<PatientDTO>> getAllPatients() {

		List<Patient> patients = patientService.findAll();

		List<PatientDTO> patientDTO = new ArrayList<>();
		for (Patient p : patients) {
			patientDTO.add(new PatientDTO(p));
		}

		return new ResponseEntity<>(patientDTO, HttpStatus.OK);
	}
}
