package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.*;
import com.example.demo.model.enums.AppointmentStatusValue;
import com.example.demo.model.enums.AppointmentTypeValues;
import com.example.demo.service.AppointmentTypeService;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.AppointmentDTO;
import com.example.demo.model.Appointment;
import com.example.demo.model.Patient;
import com.example.demo.model.enums.AppointmentStatusValue;
import com.example.demo.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {
	
	private final AppointmentService appointmentService;
	private final DoctorService doctorService;
	private final AppointmentTypeService appointmentTypeService;
    
	@Autowired
	public AppointmentController(AppointmentService appointmentService, DoctorService doctorService, AppointmentTypeService appointmentTypeService) {
		this.appointmentService = appointmentService;
		this.doctorService = doctorService;
		this.appointmentTypeService = appointmentTypeService;
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

	@GetMapping(value = "/allConsultations")
	public ResponseEntity<List<AppointmentDTO>> getAllConsultations() {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("consultation"))
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/allExaminations")
	public ResponseEntity<List<AppointmentDTO>> getAllExaminations() {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("examination"))
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/allConsultations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getAllPharmacistConsultations(@PathVariable Long id) {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("consultation")
			   & a.getDoctor().getId() == id)
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/allExaminations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getAllDermatologistExaminations(@PathVariable Long id) {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("examination")
			   & a.getDoctor().getId() == id)
				appointments.add(a);

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

	@PostMapping(value = "/defineNewAppointment")
	//@PreAuthorize("hasRole('PHARMACY_ADMIN')")
	public ResponseEntity<AppointmentDTO> defineNewAppointment(@RequestBody AppointmentDTO appointmentDTO) {
		System.out.println("-------- Defining new Appointment --------");
		System.out.println(appointmentDTO.toString());
		Doctor doctor = doctorService.findOne(appointmentDTO.getDoctor().getId());
		appointmentDTO.setDoctor(null);
		Appointment appointment  = new Appointment(appointmentDTO);
		appointment.setDoctor(doctor);

		AppointmentType appointmentType = new AppointmentType();
		if ( appointmentDTO.getAppointmentType().getAppointmentTypeValue() == AppointmentTypeValues.CONSULTATION)
			appointmentType.setAppointmentTypeValue(AppointmentTypeValues.CONSULTATION);
		else
			appointmentType.setAppointmentTypeValue(AppointmentTypeValues.EXAMINATION);
		appointmentTypeService.save(appointmentType);

		System.out.println(appointment.toString());

		appointmentService.save(appointment);

		return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);
	}

	@GetMapping(value = "/patient")
//	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<AppointmentDTO>> getDoneByPatient() {

		//Izdvojimo pacijenta iz sesije
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("OOOOOO" + currentUser.getName());
		Patient patient = new Patient();
		patient.setEmail(currentUser.getName());
		patient.setId(6L);
		List<Appointment> appointments = appointmentService.findAllByPatient(patient);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			if(a.getStatus().getStatusValue() == AppointmentStatusValue.DONE)
				appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/upcomingExaminations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getDermatologistUpcomingExaminations(@PathVariable Long id) {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("examination")
			   & a.getDoctor().getId() == id
			   & a.getStatus().getStatusValue() == AppointmentStatusValue.UPCOMING)
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/patientUpcomming")
//	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<AppointmentDTO>> getUpcommingByPatient() {

		//Izdvojimo pacijenta iz sesije
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("OOOOOO" + currentUser.getName());
		Patient patient = new Patient();
		patient.setEmail(currentUser.getName());
		patient.setId(6L);
		List<Appointment> appointments = appointmentService.findAllByPatient(patient);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			if(a.getStatus().getStatusValue() == AppointmentStatusValue.UPCOMING)
				appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/byDoctor")
//	@PreAuthorize("hasRole('PHARMACY_ADMIN')")
	public ResponseEntity<List<AppointmentDTO>> getUpcommingByDoctor(@RequestBody Doctor doctor) {
		System.out.println("-------- Get Appointments by Doctor --------");

		System.out.println("Doctor user : " + doctor.toString());

		List<Appointment> appointments = appointmentService.findAllByDoctor(doctor);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();

		for (Appointment a : appointments) {
			System.out.println(a.getId() + ": " + a.getStatus().getStatusValue());
			System.out.println("endTime: " + a.getStartTime());
			System.out.println("startTime: " + a.getEndTime());
			if(a.getStatus().getStatusValue() == AppointmentStatusValue.UPCOMING)
				appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
}