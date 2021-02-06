package com.example.demo.controller;

import com.example.demo.dto.GradeDTO;
import com.example.demo.model.Grade;
import com.example.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/grades", produces = MediaType.APPLICATION_JSON_VALUE)
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<GradeDTO>> getAllGrades() {

        List<Grade> grades = gradeService.findAll();

        List<GradeDTO> gradeDTOS = new ArrayList<>();
        for (Grade g : grades) {
            gradeDTOS.add(new GradeDTO(g));
        }

        return new ResponseEntity<>(gradeDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/userId={userId}&pharmacyId={pharmacyId}")
    public ResponseEntity<GradeDTO> getGrade(@PathVariable Long userId, @PathVariable Long pharmacyId) {

        Grade grade = gradeService.findOneByUserIdAndPharmacyId(userId, pharmacyId);

        if (grade == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new GradeDTO(grade), HttpStatus.OK);
    }

    @PostMapping(value = "/userId={userId}&pharmacyId={pharmacyId}")
    public ResponseEntity<GradeDTO> updateGrade(@PathVariable Long userId, @PathVariable Long pharmacyId, @RequestBody int value) {

        Grade grade = gradeService.findOneByUserIdAndPharmacyId(userId, pharmacyId);

        if (grade == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        gradeService.remove(grade.getId());
        grade.setValue(value);
        gradeService.save(grade);

        return new ResponseEntity<>(new GradeDTO(grade), HttpStatus.OK);
    }
}
