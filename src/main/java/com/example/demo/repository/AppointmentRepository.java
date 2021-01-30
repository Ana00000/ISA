package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	Appointment findOneById(Long id);
	
	Page<Appointment> findAll(Pageable pageable);
	
	List<Appointment> findAllByStartTime(Timestamp startTime);

	List<Appointment> findAllByEndTime(Timestamp endTime);

	List<Appointment> findAllByPrice(double price);
}