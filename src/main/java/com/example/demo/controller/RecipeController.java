package com.example.demo.controller;

import com.example.demo.dto.RecipeDto;
import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import com.example.demo.service.impl.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/recipe", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService){

        this.recipeService = recipeService;
    }
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<RecipeDto> getById(@PathVariable Long id){

        Recipe recipe = recipeService.findOne(id);
        RecipeDto recipeDto = new RecipeDto(recipe);
        return new ResponseEntity<>(recipeDto, HttpStatus.OK);
    }
}
