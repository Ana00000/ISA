package com.example.demo.repository;

import com.example.demo.model.Patient;
import com.example.demo.model.Recipe;
import com.example.demo.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    List<Recipe> findAllByPatient(Patient patient);

    Recipe findOneById(Long id);

}
