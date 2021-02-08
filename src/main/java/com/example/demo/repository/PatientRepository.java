package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findOneByPassword(String password);
	
	Page<Patient> findAll(Pageable pageable);
	
	List<Patient> findAllByName(String name);
	
	List<Patient> findAllByLastName(String lastName);
	
	List<Patient> findByNameAndLastNameAllIgnoringCase(String name, String lastName);
	
	List<Patient> findAllByEmail(String email);

	Patient findOneByEmail(String email);

	List<Patient> findAllBySubscribedToPromotions(Boolean subscribedToPromotions);
}
