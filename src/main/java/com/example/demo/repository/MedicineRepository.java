package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	Medicine findOneById(Long id);
	
	Page<Medicine> findAll(Pageable pageable);

	List<Medicine> findAllByName(String name);
	
	List<Medicine> findAllByRecipeNeed(boolean recipeNeed);
}
