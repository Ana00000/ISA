package com.example.demo.repository;

import com.example.demo.model.MedicineReservation;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineReservationRepository extends JpaRepository<MedicineReservation, Long> {
    List<MedicineReservation> findAllByPatient(Patient patient);
}
