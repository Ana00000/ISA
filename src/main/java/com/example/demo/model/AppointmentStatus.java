package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.AppointmentStatusValue;

@Entity
public class AppointmentStatus {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    
    @Column(name="statusValue", unique=false, nullable=false)
    private AppointmentStatusValue statusValue;

    public AppointmentStatus() {
    }

	public AppointmentStatus(Long id, AppointmentStatusValue statusValue) {
		super();
		this.id = id;
		this.statusValue = statusValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppointmentStatusValue getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(AppointmentStatusValue statusValue) {
		this.statusValue = statusValue;
	}
}
