package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.AppointmentTypeValues;

@Entity
public class AppointmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="appointmentTypeValue", unique=false, nullable=false)
    private AppointmentTypeValues appointmentTypeValue;

    public AppointmentType() {
    }
    
	public AppointmentType(long id, AppointmentTypeValues appointmentTypeValue) {
		super();
		this.id = id;
		this.appointmentTypeValue = appointmentTypeValue;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AppointmentTypeValues getAppointmentTypeValue() {
		return appointmentTypeValue;
	}

	public void setAppointmentTypeValue(AppointmentTypeValues appointmentTypeValue) {
		this.appointmentTypeValue = appointmentTypeValue;
	}
}
