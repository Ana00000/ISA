package com.example.demo.controller;

import com.example.demo.dto.MedicineReservationDTO;
import com.example.demo.model.*;
import com.example.demo.model.enums.MedicineReservationStatusValue;
import com.example.demo.service.MedicineReservationService;
import com.example.demo.service.MedicineService;
import com.example.demo.service.PatientService;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/medicineReservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineReservationController {
    @Autowired
    private MedicineReservationService medicineReservationService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PharmacyService pharmacyService;

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
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

//        Patient patient = patientService.findOne(Long.parseLong(currentUser.getName()));
        Patient patient = patientService.findOne(4L);
        Medicine medicine = medicineService.findOne(reservationRequest.getMedicineDTO().getId());
        Pharmacy pharmacy = pharmacyService.findOne(reservationRequest.getPharmacyDTO().getId());
        PharmacyMedicine pharmacyMedicine = medicineReservationService.findOnePharmacyMedicine(
                new PharmacyMedicinePK(medicine, pharmacy));

        if( pharmacyMedicine == null ){
            //This pharmacy doesn't contain this medicine, we need to send user to another pharmacy
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Hello there");
        System.out.println("Kolicina: " + pharmacyMedicine.getQuantity() + " / " + reservationRequest.getQuantity() );
        //check patients penalties
        //check if patient is allergic
        //check if pharmacy has enough quantity
        if( reservationRequest.getQuantity() >= pharmacyMedicine.getQuantity() ){
            //Exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //save reservation
        MedicineReservation medicineReservation = new MedicineReservation();
        medicineReservation.setReservationStatus(MedicineReservationStatusValue.ACTIVE);
        medicineReservation.setQuantity(reservationRequest.getQuantity());
        medicineReservation.setMedicine(medicine);
        medicineReservation.setPharmacy(pharmacy);
        medicineReservation.setPickUpDate(reservationRequest.getPickUpDate());
        medicineReservation.setPatient(patient);
        MedicineReservation retValue = medicineReservationService.save(medicineReservation);

        //Update quantity of medicine in pharmacy
        pharmacyMedicine.setQuantity(pharmacyMedicine.getQuantity() - reservationRequest.getQuantity());
        medicineReservationService.updatePharmacyMedicine(pharmacyMedicine);

        return new ResponseEntity<>(reservationRequest, HttpStatus.OK);
    }


}
