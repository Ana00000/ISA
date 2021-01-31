package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findOneById(Long id);
	
	Page<Patient> findAll(Pageable pageable);
	
	List<Patient> findAllByName(String name);
	
	List<Patient> findAllByLastName(String lastName);
	
	List<Patient> findByNameAndLastNameAllIgnoringCase(String name, String lastName);
	
	List<Patient> findAllByEmail(String email);
}
