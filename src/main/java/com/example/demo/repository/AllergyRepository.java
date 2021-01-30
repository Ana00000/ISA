package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Allergy;

public interface AllergyRepository extends JpaRepository<Allergy, Long> {
	
	Allergy findOneById(Long id);
	
	Page<Allergy> findAll(Pageable pageable);
}
