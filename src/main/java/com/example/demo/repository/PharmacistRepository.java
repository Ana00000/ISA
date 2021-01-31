package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pharmacist;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {

	Pharmacist findOneById(Long id);

	Pharmacist findOneByPassword(String password);
	
	Page<Pharmacist> findAll(Pageable pageable);

	List<Pharmacist> findAllByName(String name);
	
	List<Pharmacist> findAllByLastName(String lastName);
	
	List<Pharmacist> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

	List<Pharmacist> findAllByEmail(String email);
}
