package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TypeOfMedicine;

public interface TypeOfMedicineRepository extends JpaRepository<TypeOfMedicine, Long> {

	TypeOfMedicine findOneById(Long id);
	
	Page<TypeOfMedicine> findAll(Pageable pageable);
}
