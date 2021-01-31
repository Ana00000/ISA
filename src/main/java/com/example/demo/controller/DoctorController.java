package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping(value = "/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {
	
	private DoctorService doctorService;
    
	@Autowired
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
}
