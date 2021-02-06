package com.example.demo.repository;

import com.example.demo.model.PharmacyMedicinePK;
import com.example.demo.model.PharmacyMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyMedicineRepository extends JpaRepository<PharmacyMedicine, PharmacyMedicinePK> {
}
