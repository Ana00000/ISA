package com.example.demo.service.impl;

import com.example.demo.model.MedicinePrescription;
import com.example.demo.model.Patient;
import com.example.demo.repository.MedicinePrescriptionRepository;
import com.example.demo.service.MedicinePrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinePrescriptionServiceImpl implements MedicinePrescriptionService {
    @Autowired
    MedicinePrescriptionRepository medicinePrescriptionRepository;

    @Override
    public List<MedicinePrescription> findAllByPatient(Patient patient) {
        return medicinePrescriptionRepository.findAllByPatient(patient);
    }
}
