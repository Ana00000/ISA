package com.example.demo.controller;

import com.example.demo.dto.MedicineReservationDTO;
import com.example.demo.model.*;
import com.example.demo.service.MedicineReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/medicineReservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineReservationController {
    private MedicineReservationService medicineReservationService;

    @Autowired
    public MedicineReservationController(MedicineReservationService medicineReservationService){this.medicineReservationService = medicineReservationService;}

    @GetMapping(value = "/all")
    public ResponseEntity<List<MedicineReservationDTO>> getAllReservations() {

        List<MedicineReservation> reservations = medicineReservationService.findAll();

        List<MedicineReservationDTO> reservationDTOS = new ArrayList<>();
        for (MedicineReservation a : reservations) {
            reservationDTOS.add(new MedicineReservationDTO(a));
        }

        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<MedicineReservationDTO> createReservation(@RequestBody MedicineReservationDTO reservationRequest) {
        //Need to get patient from session
        //validate DTO data for null
        System.out.println("Hello there");
        //check if pharmacy has enough quantity
        Optional<PharmacyMedicine> pharmacyMedicine = medicineReservationService.findOnePharmacyMedicine(
                new PharmacyMedicinePK(new Medicine(reservationRequest.getMedicineDTO()), new Pharmacy(reservationRequest.getPharmacyDTO())));

        System.out.println("Hello there");

        if( reservationRequest.getQuantity() >= pharmacyMedicine.get().getQuantity() ){
            //Exception
        }
        //check patients penalties
        //check if patient is allergic


        //MedicineReservation medicineReservation = medicineReservationService.save(new MedicineReservation(reservationRequest));

        //check if saved successfully

        return new ResponseEntity<>(reservationRequest, HttpStatus.OK);
    }


}
