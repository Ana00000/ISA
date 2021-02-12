package com.example.demo.controller;

import com.example.demo.dto.Hadzi.MedicineReservationDTOHadzi;
import com.example.demo.dto.MedicineReservationDTO;
import com.example.demo.model.*;
import com.example.demo.model.enums.MedicineReservationStatusValue;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.MedicineReservationService;
import com.example.demo.service.MedicineService;
import com.example.demo.service.PatientService;
import com.example.demo.service.PharmacyService;
import com.example.demo.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/medicineReservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineReservationController {
    @Autowired
    private MedicineReservationService medicineReservationService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<MedicineReservationDTO>> getAllReservations() {

        List<MedicineReservation> reservations = medicineReservationService.findAll();
        if( reservations == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<MedicineReservationDTO> reservationDTOS = new ArrayList<>();
        for (MedicineReservation a : reservations) {
            reservationDTOS.add(new MedicineReservationDTO(a));
        }

        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/patient")
    public ResponseEntity<List<MedicineReservationDTOHadzi>> getAllByPatient(HttpServletRequest request) {
        Appointment appointment = new Appointment();

        String token = tokenUtils.getToken(request);
        if( token == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String username = tokenUtils.getUsernameFromToken(token);
        Patient patient = patientService.findOneByEmail(username);

        List<MedicineReservation> reservations = medicineReservationService.findAll();
        List<MedicineReservationDTOHadzi> reservationDTOS = new ArrayList<>();
        for (MedicineReservation mr : reservations) {
            if(mr.getPatient().getId() == patient.getId()){
                reservationDTOS.add(new MedicineReservationDTOHadzi(mr));
            }
        }

        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);
    }
   
    @PostMapping(value = "/create")
    public ResponseEntity<String> createReservation(HttpServletRequest request, @RequestBody MedicineReservationDTOHadzi reservationRequest) {
        //Need to get patient from session
        //validate DTO data for null

        String token = tokenUtils.getToken(request);
        if( token == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String username = tokenUtils.getUsernameFromToken(token);

        Patient patient = patientService.findOneByEmail(username);
        Medicine medicine = medicineService.findOne(reservationRequest.getMedicineID());
        Pharmacy pharmacy = pharmacyService.findOne(reservationRequest.getPharmacyID());
        PharmacyMedicine pharmacyMedicine = medicineReservationService.findByMedicineAndPharmacy(medicine, pharmacy);

        if( pharmacyMedicine == null ){
            //This pharmacy doesn't contain this medicine, we need to send user to another pharmacy
            System.out.println("pharmacy medicine = null");
            return new ResponseEntity<>("This pharmacy doesn't contain chosen medicine, try another one",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Hello there");
        System.out.println("Kolicina: " + pharmacyMedicine.getQuantity() + " / " + reservationRequest.getQuantity() );
        //check patients penalties
        if( patient.getPenalties() > 3){
            //not allowed
            return new ResponseEntity<>("You are not allowed to reserve medicine, you have 3 or more penalties :/", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //check if patient is allergic
        for(Allergy allergy : patient.getAllergies()){
            for(MedicineIngredient mi : medicine.getIngredients()){
                if(mi.getId() == allergy.getMedicineIngredient().getId()){
                    //If he is allergic he can't take the drug
                    return new ResponseEntity<>("You can't reserve the medicine, you are allergic to it. Care of yourself.", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
        //check if pharmacy has enough quantity
        if( reservationRequest.getQuantity() > pharmacyMedicine.getQuantity() ){
            //Exception
            System.out.println("too few quantity");
            return new ResponseEntity<>("Not enough quantity. You can reserve " + pharmacyMedicine.getQuantity(), HttpStatus.INTERNAL_SERVER_ERROR);
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
        pharmacyMedicine.setQuantity((int) (pharmacyMedicine.getQuantity() - reservationRequest.getQuantity()));
        medicineReservationService.updatePharmacyMedicine(pharmacyMedicine);

        emailService.sendEmail(patient.getEmail(), "New Reservation", "reservation");

        return new ResponseEntity<>("successful", HttpStatus.OK);
    }

    @PostMapping(value = "/cancel")
    public ResponseEntity<String> cancelReservation(HttpServletRequest request, @RequestBody MedicineReservationDTOHadzi reservationRequest) {
        System.out.println("Hello there");
        String token = tokenUtils.getToken(request);
        if( token == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String username = tokenUtils.getUsernameFromToken(token);

        Patient patient = patientService.findOneByEmail(username);
        Medicine medicine = medicineService.findOne(reservationRequest.getMedicineID());
        Pharmacy pharmacy = pharmacyService.findOne(reservationRequest.getPharmacyID());
        PharmacyMedicine pharmacyMedicine = medicineReservationService.findByMedicineAndPharmacy(medicine, pharmacy);

        //check for the time
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();

        if(reservationRequest.getPickUpDate().before(date)){
            //cannot cancel reservation, If patient don't pick up medicine he get's one penalty
            patient.setPenalties(patient.getPenalties() + 1);
            patientService.save(patient);
            System.out.println("Invalid date");
            return new ResponseEntity<>("You didn't cancel reservation at the time, enjoy your penalty! ;)",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //if good, cancel it
        MedicineReservation medicineReservation = medicineReservationService.findOne(reservationRequest.getId());
        medicineReservation.setReservationStatus(MedicineReservationStatusValue.CANCELED);
        medicineReservationService.save(medicineReservation);

        //update medicine quantity in pharmacy
        pharmacyMedicine.setQuantity((int) (pharmacyMedicine.getQuantity() + reservationRequest.getQuantity()));
        medicineReservationService.updatePharmacyMedicine(pharmacyMedicine);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
