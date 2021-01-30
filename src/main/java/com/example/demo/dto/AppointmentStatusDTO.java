package com.example.demo.dto;

import com.example.demo.model.AppointmentStatus;
import com.example.demo.model.enums.AppointmentStatusValue;

public class AppointmentStatusDTO {
	private Long id;
	private AppointmentStatusValue statusValue;
	 
	public AppointmentStatusDTO() {
		}
		
	public AppointmentStatusDTO(AppointmentStatus appointmentStatus) {
		this(appointmentStatus.getId(), appointmentStatus.getStatusValue());
	}

	public AppointmentStatusDTO(Long id, AppointmentStatusValue statusValue) {
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
