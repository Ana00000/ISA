package com.example.demo.service.impl;

import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ApointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    
	@Autowired
	public ApointmentServiceImpl(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
    
    public Appointment findOne(Long id) {
		return appointmentRepository.findById(id).orElseGet(null);
	}

	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}
	
	public Page<Appointment> findAll(Pageable page) {
		return appointmentRepository.findAll(page);
	}
	
	public List<Appointment> findAllByStartTime(Timestamp startTime) {
		return appointmentRepository.findAllByStartTime(startTime);
	}

	public List<Appointment> findAllByEndTime(Timestamp endTime) {
		return appointmentRepository.findAllByEndTime(endTime);
	}
	
	public List<Appointment> findAllByPrice(double price) {
		return appointmentRepository.findAllByPrice(price);
	}

	@Override
	public List<Appointment> findAllByPatient(Patient patient) {
		return appointmentRepository.findAllByPatient(patient);
	}

	@Override
	public List<Appointment> findAllByDoctor(Doctor doctor) { 
		return appointmentRepository.findAllByDoctor(doctor); 
	}

	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public void remove(Long id) {
		appointmentRepository.deleteById(id);
	}
}
