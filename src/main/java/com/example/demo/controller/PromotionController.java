package com.example.demo.controller;

import com.example.demo.dto.PromotionDTO;
import com.example.demo.model.Patient;
import com.example.demo.model.Promotion;
import com.example.demo.service.PatientService;
import com.example.demo.service.PromotionService;
import com.example.demo.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/promotions", produces = MediaType.APPLICATION_JSON_VALUE)
public class PromotionController {

    private final PromotionService promotionService;
    private final PatientService patientService;
    private final EmailServiceImpl emailService;

    @Autowired
    public PromotionController(PromotionService promotionService, PatientService patientService, EmailServiceImpl emailService) {
        this.promotionService = promotionService;
        this.patientService = patientService;
        this.emailService = emailService;
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

        List<Patient> subscribedPatients = patientService.findAllBySubscribedToPromotions(true);

        String from = new SimpleDateFormat("dd.MM.yyyy. HH:mm").format(promotion.getStart());
        String to = new SimpleDateFormat("dd.MM.yyyy. HH:mm").format(promotion.getEnd());

        for(Patient p : subscribedPatients){
            String promotionStringStart = "Dear mr./mrs. " + p.getName() + " " + p.getLastName() + ",\n\n";
            String promotionStringEnd = "\n\nPromotion will be active in period \nfrom: " + from + "\nto: " + to + "\n\nSincerely Yours,\nIsa I Bisa Team";
            emailService.sendEmail(p.getEmail(), promotionStringStart + promotion.getDescription() + promotionStringEnd, "NEW PROMOTION");
        }

        return new ResponseEntity<>(promotionDTO, HttpStatus.CREATED);
    }
}
