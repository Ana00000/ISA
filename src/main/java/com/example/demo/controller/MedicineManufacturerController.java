package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.MedicineManufacturerDTO;
import com.example.demo.model.MedicineManufacturer;
import com.example.demo.service.MedicineManufacturerService;

import org.springframework.http.MediaType;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/medicineManufacturers", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineManufacturerController {
	
	private MedicineManufacturerService medicineManufacturerService;
    
	@Autowired
	public MedicineManufacturerController(MedicineManufacturerService medicineManufacturerService) {
		this.medicineManufacturerService = medicineManufacturerService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<MedicineManufacturerDTO>> getAllMedicineManufacturers() {

		List<MedicineManufacturer> medicineManufacturers = medicineManufacturerService.findAll();

		List<MedicineManufacturerDTO> medicineManufacturersDTO = new ArrayList<>();
		for (MedicineManufacturer mm : medicineManufacturers) {
			medicineManufacturersDTO.add(new MedicineManufacturerDTO(mm));
		}

		return new ResponseEntity<>(medicineManufacturersDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicineManufacturerDTO> getMedicineManufacturer(@PathVariable Long id) {

		MedicineManufacturer medicineManufacturer = medicineManufacturerService.findOne(id);

		if (medicineManufacturer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new MedicineManufacturerDTO(medicineManufacturer), HttpStatus.OK);
	}
}