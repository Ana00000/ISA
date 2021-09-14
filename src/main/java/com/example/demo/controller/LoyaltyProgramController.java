package com.example.demo.controller;

import com.example.demo.model.LoyaltyProgram;
import com.example.demo.service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/loyaltyProgram", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoyaltyProgramController {

    @Autowired
    private LoyaltyProgramService loyaltyProgramService;

    @GetMapping(value = "/getIt")
    public ResponseEntity<LoyaltyProgram> getLoyaltyProgram(){
        LoyaltyProgram loyaltyProgram = loyaltyProgramService.findAll().get(0);
        return new ResponseEntity<>(loyaltyProgram, HttpStatus.OK);
    }

    @PostMapping(value = "/changeProgram")
    public ResponseEntity<LoyaltyProgram> addLoyaltyProgram(@RequestBody LoyaltyProgram loyaltyProgram){
        loyaltyProgramService.save(loyaltyProgram);
        return new ResponseEntity<>(loyaltyProgram,HttpStatus.OK);
    }
}
