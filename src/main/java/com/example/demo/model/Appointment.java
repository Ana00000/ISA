package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(name="price", unique=false, nullable=false)
    private double price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AppointmentType type;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AppointmentStatus status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Doctor doctor;

    @Column(nullable = false)
    private Timestamp startTime;

    @Column(nullable = false)
    private Timestamp endTime;

	public Appointment() {
	}

	public Appointment(long id, double price, AppointmentType type, AppointmentStatus status, Patient patient,
			Doctor doctor, Timestamp startTime, Timestamp endTime) {
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

	public AppointmentType getType() {
		return type;
	}

	public void setType(AppointmentType type) {
		this.type = type;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
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
