package com.example.demo.service;

import com.example.demo.model.MedicineType;
import com.example.demo.repository.MedicineTypeRepository;

import java.util.List;

public interface MedicineTypeService {
    List<MedicineType> findAll();

    List<MedicineType> findAllByType(String type);

    MedicineType save(MedicineTypeRepository medicineType);
}
