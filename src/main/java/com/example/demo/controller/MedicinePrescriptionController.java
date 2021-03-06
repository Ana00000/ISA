package com.example.demo.controller;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.MedicinePrescriptionDTO;
import com.example.demo.model.MedicinePrescription;
import com.example.demo.model.Patient;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.MedicinePrescriptionService;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/prescriptions", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicinePrescriptionController {
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicinePrescriptionService medicinePrescriptionService;

    @GetMapping(value = "/patient")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<MedicinePrescriptionDTO>> getDoneByPatientDone(HttpServletRequest request) {
        //Get patient from session
        String token = tokenUtils.getToken(request);
        if( token == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String username = tokenUtils.getUsernameFromToken(token);
        Patient patient = patientService.findOneByEmail(username);

        List<MedicinePrescription> medicinePrescriptions = medicinePrescriptionService.findAllByPatient(patient);

        List<MedicinePrescriptionDTO> medicinePrescriptionsDTO = new ArrayList<>();
        for (MedicinePrescription medicinePrescription : medicinePrescriptions) {
            medicinePrescriptionsDTO.add(new MedicinePrescriptionDTO(medicinePrescription));
        }

        return new ResponseEntity<>(medicinePrescriptionsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/medicine")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Set<MedicineDTO>> getIssuedMedicine(HttpServletRequest request) {
        //Get patient from session
        String token = tokenUtils.getToken(request);
        if( token == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String username = tokenUtils.getUsernameFromToken(token);
        Patient patient = patientService.findOneByEmail(username);

        List<MedicinePrescription> medicinePrescriptions = medicinePrescriptionService.findAllByPatient(patient);

        Set<MedicineDTO> medicineDTO = new HashSet<>();
        for (MedicinePrescription medicinePrescription : medicinePrescriptions) {
            MedicineDTO med = new MedicineDTO(medicinePrescription.getMedicine());
            Boolean contains = false;
            for(MedicineDTO m : medicineDTO){
                if(m.getId() == med.getId()){
                    contains = true;
                    break;
                }
            }
            if( !contains)
                medicineDTO.add(med);
        }

        return new ResponseEntity<>(medicineDTO, HttpStatus.OK);
    }
}
