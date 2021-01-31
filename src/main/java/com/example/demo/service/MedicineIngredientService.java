package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.MedicineIngredient;

public interface MedicineIngredientService {
	
	MedicineIngredient findOne(Long id);
    
	List<MedicineIngredient> findAll();
	
	Page<MedicineIngredient> findAll(Pageable page);

	List<MedicineIngredient> findAllByName(String name);
	
	MedicineIngredient save(MedicineIngredient medicineIngredient);

	void remove(Long id);
}