package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

}
