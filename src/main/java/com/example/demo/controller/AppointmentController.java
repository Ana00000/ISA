package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AppointmentDTO;
import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {
	
	private AppointmentService appointmentService;
    
	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {

		List<Appointment> appointments = appointmentService.findAll();

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Long id) {

		Appointment appointment = appointmentService.findOne(id);

		if (appointment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);
	}

	@GetMapping(value = "/patient")
	public ResponseEntity<List<AppointmentDTO>> getByPatient() {

		//Izdvojimo pacijenta iz sesije

		Patient patient = new Patient();
		List<Appointment> appointments = appointmentService.findAllByPatient(patient);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
}