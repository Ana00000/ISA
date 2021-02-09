package com.example.demo.dto;

import java.sql.Timestamp;
import com.example.demo.model.Appointment;
import com.example.demo.model.TimeInterval;

public class AppointmentDTO {
	private Long id;
	private double price;
	private AppointmentTypeDTO appointmentType;
	private AppointmentStatusDTO status;
	private PatientDTO patient;
	private DoctorDTO doctor;
	private Timestamp startTime;
	private Timestamp endTime;
	private TimeInterval timeInterval;
	 
	public AppointmentDTO() {
	}
	
	public AppointmentDTO(Appointment appointment) {
		this.id = appointment.getId();
		this.price = appointment.getPrice();
		this.appointmentType = new AppointmentTypeDTO(appointment.getAppointmentType());
		this.status = new AppointmentStatusDTO(appointment.getStatus());
		this.patient = new PatientDTO(appointment.getPatient());
		this.doctor = new DoctorDTO(appointment.getDoctor(), appointment.getDoctor().getType());
//		this.startTime = appointment.getStartTime();
//		this.endTime = appointment.getEndTime();
		this.timeInterval = appointment.getTimeInterval();
	}

	public AppointmentDTO(Long id, double price, AppointmentTypeDTO appointmentType, AppointmentStatusDTO status,
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

	public TimeInterval getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(TimeInterval timeInterval) {
		this.timeInterval = timeInterval;
	}
}
