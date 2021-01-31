package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MedicineManufacturer;

public interface MedicineManufacturerRepository extends JpaRepository<MedicineManufacturer, Long> {

	Page<MedicineManufacturer> findAll(Pageable pageable);

	List<MedicineManufacturer> findAllByName(String name);
}
