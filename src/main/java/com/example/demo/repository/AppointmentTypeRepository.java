package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AppointmentType;

public interface AppointmentTypeRepository extends JpaRepository<AppointmentType, Long> {

	AppointmentType findOneById(Long id);
	
	Page<AppointmentType> findAll(Pageable pageable);
}
