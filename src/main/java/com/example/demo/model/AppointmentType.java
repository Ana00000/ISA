package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.AppointmentTypeValues;

@Entity
public class AppointmentType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="value", unique=false, nullable=false)
    private AppointmentTypeValues value;

    public AppointmentType() {
    }
    
	public AppointmentType(long id, AppointmentTypeValues value) {
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

	public AppointmentTypeValues getValue() {
		return value;
	}

	public void setValue(AppointmentTypeValues value) {
		this.value = value;
	}
}
