package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.TypeOfMedicineDTO;
import com.example.demo.model.TypeOfMedicine;
import com.example.demo.service.TypeOfMedicineService;

import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/typeOfMedicine", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeOfMedicineController {
	
	private TypeOfMedicineService typeOfMedicineService;
    
	@Autowired
	public TypeOfMedicineController(TypeOfMedicineService typeOfMedicineService) {
		this.typeOfMedicineService = typeOfMedicineService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<TypeOfMedicineDTO>> getAllTypesOfMedicine() {

		List<TypeOfMedicine> typesOfMedicine = typeOfMedicineService.findAll();

		List<TypeOfMedicineDTO> typesOfMedicineDTO = new ArrayList<>();
		for (TypeOfMedicine tom : typesOfMedicine) {
			typesOfMedicineDTO.add(new TypeOfMedicineDTO(tom));
		}

		return new ResponseEntity<>(typesOfMedicineDTO, HttpStatus.OK);
	}
}