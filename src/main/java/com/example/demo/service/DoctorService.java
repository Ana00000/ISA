package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.Doctor;

public interface DoctorService {
	
	Doctor findOne(Long id);
	    
	Doctor findOneByPassword(String password);

	List<Doctor> findAll();
	
	Page<Doctor> findAll(Pageable page);
	
	List<Doctor> findAllByType(String type);
	
	List<Doctor> findAllByName(String name);
	
	List<Doctor> findAllByLastName(String lastName);
	
	List<Doctor> findByNameAndLastNameAllIgnoringCase(String name, String lastName);
	
	List<Doctor> findAllByEmail(String email);

	Doctor findOneByEmail(String email);

	Doctor save(Doctor doctor);

	void remove(Long id);
}