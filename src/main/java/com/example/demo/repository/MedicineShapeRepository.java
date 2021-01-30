package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MedicineShape;

public interface MedicineShapeRepository extends JpaRepository<MedicineShape, Long> {

	MedicineShape findOneById(Long id);
	
	Page<MedicineShape> findAll(Pageable pageable);
}
