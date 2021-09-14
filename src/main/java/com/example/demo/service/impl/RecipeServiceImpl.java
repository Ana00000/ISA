package com.example.demo.service.impl;

import com.example.demo.model.Patient;
import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository){

        this.recipeRepository = recipeRepository;
    }
    @Override
    public Recipe findOne(Long id) {
        return recipeRepository.findOneById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> findAllByPatient(Patient patient) {
        return recipeRepository.findAllByPatient(patient);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void remove(Long id) {
        recipeRepository.deleteById(id);
    }
}
