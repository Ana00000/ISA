package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;

import com.example.demo.model.TimeInterval;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	Page<Appointment> findAll(Pageable pageable);
	
//	List<Appointment> findAllByStartTime(Timestamp start);
//
//	List<Appointment> findAllByEndTime(Timestamp end);

	List<Appointment> findAllByTimeInterval(TimeInterval timeInterval);

	List<Appointment> findAllByPrice(double price);

	List<Appointment> findAllByPatient(Patient patient);

	List<Appointment> findAllByDoctor(Doctor doctor);
}