package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MedicineIngredient;

public interface MedicineIngredientRepository extends JpaRepository<MedicineIngredient, Integer> {

}
