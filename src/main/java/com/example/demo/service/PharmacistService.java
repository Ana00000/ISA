package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.Pharmacist;

public interface PharmacistService {
	
	Pharmacist findOne(Long id);
	    
	Pharmacist findOneByPassword(String password);

	List<Pharmacist> findAll();
	
	Page<Pharmacist> findAll(Pageable page);
	
	List<Pharmacist> findAllByName(String name);
	
	List<Pharmacist> findAllByLastName(String lastName);
	
	List<Pharmacist> findByNameAndLastNameAllIgnoringCase(String name, String lastName);
	
	List<Pharmacist> findAllByEmail(String email);

	Pharmacist save(Pharmacist pharmacist);

	void remove(Long id);
}
