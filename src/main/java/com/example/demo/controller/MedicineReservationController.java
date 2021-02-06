package com.example.demo.controller;

import com.example.demo.dto.MedicineReservationDTO;
import com.example.demo.model.*;
import com.example.demo.service.MedicineReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/create")
    public ResponseEntity<MedicineReservationDTO> createReservation(@RequestBody MedicineReservationDTO reservationRequest) {
        //validate DTO data for null

        //check if pharmacy has enough quantity
        Optional<PharmacyMedicine> pharmacyMedicine = medicineReservationService.findOnePharmacyMedicine(
                new PharmacyMedicinePK(new Medicine(reservationRequest.getMedicineDTO()), new Pharmacy(reservationRequest.getPharmacyDTO())));
        if( reservationRequest.getQuantity() >= pharmacyMedicine.get().getQuantity() ){
            //Exception
        }
        //check patients penalties
        //check if patient is allergic


        MedicineReservation medicineReservation = medicineReservationService.save(new MedicineReservation(reservationRequest));

        //check if saved successfully

        return new ResponseEntity<>(reservationRequest, HttpStatus.OK);
    }


}
