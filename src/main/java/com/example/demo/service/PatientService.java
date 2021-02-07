package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.Patient;

public interface PatientService {
	
	Patient findOne(Long id);
	    
	Patient findOneByPassword(String password);

	List<Patient> findAll();
	
	Page<Patient> findAll(Pageable page);
	
	List<Patient> findAllByName(String name);
	
	List<Patient> findAllByLastName(String lastName);
	
	List<Patient> findByNameAndLastNameAllIgnoringCase(String name, String lastName);
	
	List<Patient> findAllByEmail(String email);

	List<Patient> findAllBySubscribedToPromotions(Boolean subscribedToPromotions);

	Patient save(Patient patient);

	void remove(Long id);
}