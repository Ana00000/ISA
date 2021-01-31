package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.Medicine;

public interface MedicineService {
	
	Medicine findOne(Long id);
    
	List<Medicine> findAll();
	
	Page<Medicine> findAll(Pageable page);
	
	List<Medicine> findAllByName(String name);
	
	List<Medicine> findAllByRecipeNeed(boolean recipeNeed);

	Medicine save(Medicine medicine);

	void remove(Long id);
}