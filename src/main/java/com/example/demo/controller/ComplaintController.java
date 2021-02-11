package com.example.demo.controller;

import com.example.demo.dto.ComplaintDTO;
import com.example.demo.model.Complaint;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Pharmacy;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/complaint", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComplaintController {
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    ComplaintService complaintService;

    @PostMapping("/new")
    public ResponseEntity<ComplaintDTO> newComplaint(HttpServletRequest request, @RequestBody ComplaintDTO complaintDTO){
        String token = tokenUtils.getToken(request);
        if( token == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String username = tokenUtils.getUsernameFromToken(token);
        Patient patient = patientService.findOneByEmail(username);
        Complaint complaint = new Complaint();
        complaint.setPatient(patient);
        if(complaintDTO.getType().equals("doctor")){
            Doctor doctor = doctorService.findOne(complaintDTO.getDoctorID());
            complaint.setDoctor(doctor);
            complaint.setPharmacy(null);
        }else{
            Pharmacy pharmacy = pharmacyService.findOne(complaintDTO.getPharmacyID());
            complaint.setPharmacy(pharmacy);
            complaint.setDoctor(null);
        }
        complaint.setText(complaintDTO.getText());

        complaintService.save(complaint);

        return new ResponseEntity<>(complaintDTO, HttpStatus.OK);
    }
}
