package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;

public interface AppointmentService {
	
	Appointment findOne(Long id);

	List<Appointment> findAll();
	
	Page<Appointment> findAll(Pageable page);
	
	List<Appointment> findAllByStartTime(Timestamp startTime);

	List<Appointment> findAllByEndTime(Timestamp endTime);
	
	List<Appointment> findAllByPrice(double price);

	List<Appointment> findAllByPatient(Patient patient);
	
	List<Appointment> findAllByDoctor(Doctor doctor);

	Appointment save(Appointment appointment);

	void remove(Long id);
}
