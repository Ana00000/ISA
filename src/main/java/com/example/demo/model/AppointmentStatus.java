package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.AppointmentStatusValue;

@Entity
public class AppointmentStatus 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="value", unique=false, nullable=false)
    private AppointmentStatusValue value;

    public AppointmentStatus() {
    }

	public AppointmentStatus(long id, AppointmentStatusValue value) {
		super();
		this.id = id;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AppointmentStatusValue getValue() {
		return value;
	}

	public void setValue(AppointmentStatusValue value) {
		this.value = value;
	}
}
