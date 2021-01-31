package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MedicineIngredientDTO;
import com.example.demo.model.MedicineIngredient;
import com.example.demo.service.MedicineIngredientService;

import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/medicineIngredient", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineIngredientController {
	
	private MedicineIngredientService medicineIngredientService;
    
	@Autowired
	public MedicineIngredientController(MedicineIngredientService medicineIngredientService) {
		this.medicineIngredientService = medicineIngredientService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<MedicineIngredientDTO>> getAllMedicineIngredients() {

		List<MedicineIngredient> medicineIngredients = medicineIngredientService.findAll();

		List<MedicineIngredientDTO> medicineIngredientsDTO = new ArrayList<>();
		for (MedicineIngredient mi : medicineIngredients) {
			medicineIngredientsDTO.add(new MedicineIngredientDTO(mi));
		}

		return new ResponseEntity<>(medicineIngredientsDTO, HttpStatus.OK);
	}
}