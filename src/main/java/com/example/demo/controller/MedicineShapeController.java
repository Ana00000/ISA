package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.MedicineShapeDTO;
import com.example.demo.model.MedicineShape;
import com.example.demo.service.MedicineShapeService;

import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/medicineShapes", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineShapeController {
	
	private MedicineShapeService medicineShapeService;
    
	@Autowired
	public MedicineShapeController(MedicineShapeService medicineShapeService) {
		this.medicineShapeService = medicineShapeService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<MedicineShapeDTO>> getAllMedicineShapes() {

		List<MedicineShape> medicineShapes = medicineShapeService.findAll();

		List<MedicineShapeDTO> medicineShapesDTO = new ArrayList<>();
		for (MedicineShape ms : medicineShapes) {
			medicineShapesDTO.add(new MedicineShapeDTO(ms));
		}

		return new ResponseEntity<>(medicineShapesDTO, HttpStatus.OK);
	}
}