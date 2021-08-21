package com.example.demo.repository;

import com.example.demo.model.MedicineType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineTypeRepository extends JpaRepository<MedicineType, Long> {

    List<MedicineType> findAll();

    List<MedicineType> findAllByType(String type);

    MedicineType findByType(String type);

    MedicineType save(MedicineTypeRepository medicineType);

}
