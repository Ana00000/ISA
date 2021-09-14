package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.dto.MedicineToAddDTO;
import com.example.demo.model.MedicineIngredient;
import com.example.demo.model.MedicineManufacturer;
import com.example.demo.model.MedicineShape;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Medicine;
import com.example.demo.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository medicineRepository;
    private MedicineTypeRepository medicineTypeRepository;
    private MedicineShapeRepository medicineShapeRepository;
    private MedicineIngredientRepository medicineIngredientRepository;
    private MedicineManufacturerRepository medicineManufacturerRepository;

	@Autowired
	public MedicineServiceImpl(MedicineRepository medicineRepository, MedicineTypeRepository medicineTypeRepository, MedicineShapeRepository medicineShapeRepository, MedicineIngredientRepository medicineIngredientRepository, MedicineManufacturerRepository medicineManufacturerRepository) {
		this.medicineRepository = medicineRepository;
		this.medicineTypeRepository = medicineTypeRepository;
		this.medicineShapeRepository = medicineShapeRepository;
		this.medicineIngredientRepository = medicineIngredientRepository;
		this.medicineManufacturerRepository = medicineManufacturerRepository;
	}
    
    public Medicine findOne(Long id) {
		return medicineRepository.findById(id).orElseGet(null);
	}
    
	public List<Medicine> findAll() {
		return medicineRepository.findAll();
	}
	
	public Page<Medicine> findAll(Pageable page) {
		return medicineRepository.findAll(page);
	}
	
	public List<Medicine> findAllByName(String name) {
		return medicineRepository.findAllByName(name);
	}
	
	public List<Medicine> findAllByRecipeNeed(boolean recipeNeed) {
		return medicineRepository.findAllByRecipeNeed(recipeNeed);
	}
	
	public Medicine save(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	public Medicine save(MedicineToAddDTO medicineToAddDTO) {
		Medicine medicine = new Medicine(medicineToAddDTO);
		medicine.setMedicineType(medicineTypeRepository.findByType(medicineToAddDTO.getMedicinType()));

		Set<Medicine> alternativeMedicines = new HashSet<>();
		for(String medicineName: medicineToAddDTO.getAlternativeMedicines()){
				Medicine pom = medicineRepository.findByName(medicineName);
				alternativeMedicines.add(pom);
		}
		medicine.setAlternativeMedicine(alternativeMedicines);

		for(MedicineShape ms : medicineShapeRepository.findAll()){
			if(ms.getShapeValue().getText().equals(medicineToAddDTO.getMedicineShape())){
				medicine.setMedicineShape(ms);
				break;
			}
		}

		Set<MedicineIngredient> medicineIngredients = new HashSet<>();
		for(String medicineIngredientName: medicineToAddDTO.getMedicinesIngredients()){
			medicineIngredients.add(medicineIngredientRepository.findByName(medicineIngredientName));
		}
		medicine.setIngredients(medicineIngredients);

		MedicineManufacturer medicineManufacturer = medicineManufacturerRepository.findByName(medicineToAddDTO.getMedicineManufacturer());
		medicine.setMedicineManufacturer(medicineManufacturer);


		medicineRepository.save(medicine);
		return medicine;
	}

	public void remove(Long id) {
		medicineRepository.deleteById(id);
	}
}