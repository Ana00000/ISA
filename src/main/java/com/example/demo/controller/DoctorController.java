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
import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping(value = "/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {
	
	private DoctorService doctorService;
    
	@Autowired
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<DoctorDTO>> getAllDoctors() {

		List<Doctor> doctors = doctorService.findAll();

		List<DoctorDTO> doctorDTO = new ArrayList<>();
		for (Doctor d : doctors) {
			doctorDTO.add(new DoctorDTO(d, d.getType()));
		}

		return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id) {

		Doctor doctor = doctorService.findOne(id);

		if (doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new DoctorDTO(doctor, doctor.getType()), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {

		Doctor doctor = doctorService.findOne(id);

		if (doctor != null) {
			doctorService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
