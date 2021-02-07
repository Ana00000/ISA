package com.example.demo.controller;

import com.example.demo.dto.PromotionDTO;
import com.example.demo.model.Promotion;
import com.example.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/promotions", produces = MediaType.APPLICATION_JSON_VALUE)
public class PromotionController {

    private PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PromotionDTO>> getAll() {
        List<Promotion> promotions = promotionService.findAll();

        List<PromotionDTO> promotionsDTOs = new ArrayList<>();
        for(Promotion p : promotions){
            promotionsDTOs.add(new PromotionDTO(p));
        }
        return new ResponseEntity<>(promotionsDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionDTO> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(new PromotionDTO(promotionService.findOne(id)), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<PromotionDTO> save(@RequestBody PromotionDTO promotionDTO) {
        System.out.println(promotionDTO.toString());
        Promotion promotion = new Promotion(promotionDTO);
        System.out.println(promotion.toString());
        promotionService.save(promotion);
        return new ResponseEntity<>(promotionDTO, HttpStatus.CREATED);
    }
}
