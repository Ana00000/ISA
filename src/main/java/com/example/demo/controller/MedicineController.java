package com.example.demo.controller;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.MedicineService;

import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/medicine", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineController {
	
	private MedicineService medicineService;
    
	@Autowired
	public MedicineController(MedicineService medicineService) {
		this.medicineService = medicineService;
	}

	@GetMapping
	public ResponseEntity<List<MedicineDTO>> getMedicine() {
		List<Medicine> medicine = medicineService.findAll();

		List<MedicineDTO> medicineDTOS = new ArrayList<>();
		for(Medicine m : medicine){
			medicineDTOS.add(new MedicineDTO(m));
		}
		return new ResponseEntity<>(medicineDTOS, HttpStatus.OK);
	}

}