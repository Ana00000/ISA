package com.example.demo.dto;

import java.sql.Timestamp;

import com.example.demo.model.Appointment;

public class AppointmentDTO 
{
	private long id;
	private double price;
	private AppointmentTypeDTO type;
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
		this.type = new AppointmentTypeDTO(appointment.getType());
		this.status = new AppointmentStatusDTO(appointment.getStatus());
		this.patient = new PatientDTO(appointment.getPatient());
		this.doctor = new DoctorDTO(appointment.getDoctor());
		this.startTime = appointment.getStartTime();
		this.endTime = appointment.getEndTime();
	}

	public AppointmentDTO(long id, double price, AppointmentTypeDTO type, AppointmentStatusDTO status,
			PatientDTO patient, DoctorDTO doctor, Timestamp startTime, Timestamp endTime) {
		super();
		this.id = id;
		this.price = price;
		this.type = type;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public AppointmentTypeDTO getType() {
		return type;
	}

	public void setType(AppointmentTypeDTO type) {
		this.type = type;
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
