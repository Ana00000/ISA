package com.example.demo.controller;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.model.Appointment;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scheduleConsultation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScheduleConsultationController {

    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping("/new")
    public ResponseEntity<Appointment> schedule(@RequestBody AppointmentDTO appointmentDTO){

        return null;

    }

}
