package com.example.demo.repository;

import com.example.demo.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineReservationStatusRepository extends JpaRepository<Medicine, Long> {
}
