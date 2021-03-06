package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Pharmacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Dermatologist;

public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {

	Dermatologist findOneByPassword(String password);
	
	Page<Dermatologist> findAll(Pageable pageable);
	
	List<Dermatologist> findAllByName(String name);
	
	List<Dermatologist> findAllByLastName(String lastName);

	List<Dermatologist> findAllByPharmaciesIsIn(List<Pharmacy> pharmacies);
	
	List<Dermatologist> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

	List<Dermatologist> findAllByEmail(String email);
}
