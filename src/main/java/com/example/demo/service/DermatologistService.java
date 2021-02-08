package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pharmacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Dermatologist;

public interface DermatologistService {
	
	Dermatologist findOne(Long id);
	    
    Dermatologist findOneByPassword(String password);

	List<Dermatologist> findAll();
	
	Page<Dermatologist> findAll(Pageable page);
	
	List<Dermatologist> findAllByName(String name);
	
	List<Dermatologist> findAllByLastName(String lastName);
	
	List<Dermatologist> findByNameAndLastNameAllIgnoringCase(String name, String lastName);
	
	List<Dermatologist> findAllByEmail(String email);

	List<Dermatologist> findAllByPharmacies(List<Pharmacy> pharmacies);

	Dermatologist save(Dermatologist dermatologist);

	void remove(Long id);
}
