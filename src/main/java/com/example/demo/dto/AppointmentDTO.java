package com.example.demo.dto;

import java.sql.Timestamp;

import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;

public class AppointmentDTO {
	private long id;
	private double price;
	private AppointmentTypeDTO appointmentType;
	private AppointmentStatusDTO status;
	private PatientDTO patient;
	private DoctorDTO doctor;
	private Timestamp startTime;
	private Timestamp endTime;
	 
	public AppointmentDTO() {
	}
	
	public AppointmentDTO(Appointment appointment) {
		this.id = appointment.getId();
		this.price = appointment.getPrice();
		this.appointmentType = new AppointmentTypeDTO(appointment.getAppointmentType());
		this.status = new AppointmentStatusDTO(appointment.getStatus());
		this.patient = new PatientDTO(appointment.getPatient());
		this.doctor = getDoctorDTO(appointment);
		this.startTime = appointment.getStartTime();
		this.endTime = appointment.getEndTime();
	}

	public AppointmentDTO(long id, double price, AppointmentTypeDTO appointmentType, AppointmentStatusDTO status,
			PatientDTO patient, DoctorDTO doctor, Timestamp startTime, Timestamp endTime) {
		super();
		this.id = id;
		this.price = price;
		this.appointmentType = appointmentType;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	private DoctorDTO getDoctorDTO(Appointment appointment) {
		Doctor doctor = appointment.getDoctor();
		if (doctor.getType().contentEquals("pharmacist"))
			return new PharmacistDTO(appointment.getDoctor());
		else if (doctor.getType().contentEquals("dermatologist"))
			return new DermatologistDTO(appointment.getDoctor());
		return null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public AppointmentTypeDTO getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentTypeDTO appointmentType) {
		this.appointmentType = appointmentType;
	}

	public AppointmentStatusDTO getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatusDTO status) {
		this.status = status;
	}

	public PatientDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}

	public DoctorDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDTO doctor) {
		this.doctor = doctor;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}
