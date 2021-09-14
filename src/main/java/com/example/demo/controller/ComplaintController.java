package com.example.demo.controller;

import com.example.demo.Exception.MyException;
import com.example.demo.dto.ComplaintAnswerDTO;
import com.example.demo.dto.ComplaintDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.*;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
    private ComplaintService complaintService;

    @Autowired
    private ComplaintAnswerService complaintAnswerService;

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

    @GetMapping(value = "/getNotAnswered")
    public ResponseEntity<List<ComplaintDTO>> getNotAnsweredCompalintments(){
        List<Complaint> complaints = complaintService.getNotAnsweredCompalintments();
        List<ComplaintDTO> complaintDTOS = new ArrayList<>();
        for(Complaint complaint :complaints){
            complaintDTOS.add(new ComplaintDTO(complaint));
        }
        return new ResponseEntity<>(complaintDTOS,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ComplaintDTO> getComplainment(@PathVariable Long id) {
        Complaint complaint = complaintService.getById(id);
        ComplaintDTO complaintDTO = new ComplaintDTO(complaint);
        return new ResponseEntity<>(complaintDTO,HttpStatus.OK);
    }

    @PostMapping(value = "/addCompalintAnswer")
    public ResponseEntity<ComplaintAnswerDTO> addAnswer(@RequestBody ComplaintAnswerDTO complaintAnswerDTO){
        ComplaintAnswerDTO complaintAnswerDTO2 = null;
        try {
            complaintAnswerDTO2 = complaintAnswerService.save(complaintAnswerDTO);
        } catch (MyException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        if(complaintAnswerDTO2 == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(complaintAnswerDTO2,HttpStatus.CREATED);
    }

}
