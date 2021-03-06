package com.example.demo.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.example.demo.model.Appointment;

public class AppointmentDTO {
	private Long id;
	private double price;
	private AppointmentTypeDTO appointmentType;
	private AppointmentStatusDTO status;
	private PatientDTO patient;
	private DoctorDTO doctor;
	private Timestamp startTime;
	private Timestamp endTime;
	private int penalty;
	private LocalDateTime localStart;
	private LocalDateTime localEnd;
	 
	public AppointmentDTO() {
	}
	
	public AppointmentDTO(Appointment appointment) {
		this.id = appointment.getId();
		this.price = appointment.getPrice();
		this.startTime = appointment.getStartTime();
		this.endTime = appointment.getEndTime();
		
		if (appointment.getAppointmentType() != null) 
			this.appointmentType = new AppointmentTypeDTO(appointment.getAppointmentType());
		if (appointment.getStatus() != null)
			this.status = new AppointmentStatusDTO(appointment.getStatus());
		if (appointment.getPatient() != null) 
			this.patient = new PatientDTO(appointment.getPatient());
		if (appointment.getDoctor() != null) 
			this.doctor = new DoctorDTO(appointment.getDoctor(), appointment.getDoctor().getType());
		this.penalty = appointment.getPenalty();

		this.localStart = appointment.getStartTime().toLocalDateTime();
		this.localEnd = appointment.getEndTime().toLocalDateTime();
	}

	public AppointmentDTO(Long id, double price, AppointmentTypeDTO appointmentType, AppointmentStatusDTO status,
			PatientDTO patient, DoctorDTO doctor, Timestamp startTime, Timestamp endTime, int penalty) {
		super();
		this.id = id;
		this.price = price;
		this.appointmentType = appointmentType;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
		this.startTime = startTime;
		this.endTime = endTime;
		this.penalty = penalty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	public LocalDateTime getLocalStart() {
		return localStart;
	}

	public void setLocalStart(LocalDateTime localStart) {
		this.localStart = localStart;
	}

	public LocalDateTime getLocalEnd() {
		return localEnd;
	}

	public void setLocalEnd(LocalDateTime localEnd) {
		this.localEnd = localEnd;
	}
}
