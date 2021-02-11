package com.example.demo.service;

import com.example.demo.model.MedicinePrescription;
import com.example.demo.model.Patient;

import java.util.List;

public interface MedicinePrescriptionService {
    List<MedicinePrescription> findAllByPatient(Patient patient);
}
