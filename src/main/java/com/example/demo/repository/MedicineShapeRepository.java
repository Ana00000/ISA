package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MedicineShape;

public interface MedicineShapeRepository extends JpaRepository<MedicineShape, Integer> {

}
