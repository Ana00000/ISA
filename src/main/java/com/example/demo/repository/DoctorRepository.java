package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	Doctor findOneByPassword(String password);
	
	Page<Doctor> findAll(Pageable pageable);

	List<Doctor> findAllByType(String type);
	
	List<Doctor> findAllByName(String name);
	
	List<Doctor> findAllByLastName(String lastName);
	
	List<Doctor> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

	List<Doctor> findAllByEmail(String email);
	
	Doctor findOneByEmail(String email);
}
