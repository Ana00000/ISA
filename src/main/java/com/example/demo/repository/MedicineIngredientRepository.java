package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MedicineIngredient;

public interface MedicineIngredientRepository extends JpaRepository<MedicineIngredient, Long> {

	Page<MedicineIngredient> findAll(Pageable pageable);

	List<MedicineIngredient> findAllByName(String name);
}
