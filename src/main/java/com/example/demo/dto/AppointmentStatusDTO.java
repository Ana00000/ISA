package com.example.demo.dto;

import com.example.demo.model.AppointmentStatus;
import com.example.demo.model.enums.AppointmentStatusValue;

public class AppointmentStatusDTO 
{
	private long id;
	private AppointmentStatusValue value;
	 
	public AppointmentStatusDTO() {
		}
		
	public AppointmentStatusDTO(AppointmentStatus appointmentStatus) {
		this(appointmentStatus.getId(), appointmentStatus.getValue());
	}

	public AppointmentStatusDTO(long id, AppointmentStatusValue value) {
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
