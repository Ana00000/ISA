package com.example.demo.service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Recipe;
import com.example.demo.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;

public interface RecipeService {

    Recipe findOne(Long id);

    List<Recipe> findAll();

    List<Recipe> findAllByPatient(Patient patient);

    Recipe save(Recipe recipe);

    void remove(Long id);
}
