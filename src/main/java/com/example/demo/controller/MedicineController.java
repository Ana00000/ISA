package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.MedicineService;

import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/medicine", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineController {
	
	private MedicineService medicineService;
    
	@Autowired
	public MedicineController(MedicineService medicineService) {
		this.medicineService = medicineService;
	}
}