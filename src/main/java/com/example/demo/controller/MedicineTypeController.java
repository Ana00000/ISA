package com.example.demo.controller;

import com.example.demo.dto.MedicineTypeDTO;
import com.example.demo.model.MedicineType;
import com.example.demo.service.MedicineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/medicineType", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineTypeController {

    private MedicineTypeService medicineTypeService;

    @Autowired
    public MedicineTypeController(MedicineTypeService medicineTypeService){
        this.medicineTypeService = medicineTypeService;
    }

    @GetMapping(value = "/allMedicineType")
    public ResponseEntity<List<MedicineTypeDTO>> getAll(){
        List<MedicineType> medicineTypeList = medicineTypeService.findAll();
        List<MedicineTypeDTO> medicineTypeDTOS = new ArrayList<>();
        for(MedicineType m :medicineTypeList){
            medicineTypeDTOS.add(new MedicineTypeDTO(m));
        }
        return new ResponseEntity<>(medicineTypeDTOS,HttpStatus.OK);
    }
}
