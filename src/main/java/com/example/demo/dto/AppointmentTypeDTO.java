package com.example.demo.dto;

import com.example.demo.model.AppointmentType;
import com.example.demo.model.enums.AppointmentTypeValues;

public class AppointmentTypeDTO {
    private Long id;
    private AppointmentTypeValues appointmentTypeValue;
    
	public AppointmentTypeDTO() {
	}
	
	public AppointmentTypeDTO(AppointmentType appointmentType) {
		this(appointmentType.getId(), appointmentType.getAppointmentTypeValue());
	}
	
	public AppointmentTypeDTO(Long id, AppointmentTypeValues appointmentTypeValue) {
		super();
		this.id = id;
		this.appointmentTypeValue = appointmentTypeValue;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public AppointmentTypeValues getAppointmentTypeValue() {
		return appointmentTypeValue;
	}

	public void setAppointmentTypeValue(AppointmentTypeValues appointmentTypeValue) {
		this.appointmentTypeValue = appointmentTypeValue;
	}
}
