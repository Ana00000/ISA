package com.example.demo.repository;

import com.example.demo.model.MedicinePrescription;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicinePrescriptionRepository extends JpaRepository<MedicinePrescription, Long> {
    List<MedicinePrescription> findAllByPatient(Patient patient);
}
