package com.example.demo.dto;

import com.example.demo.model.AppointmentType;
import com.example.demo.model.enums.AppointmentTypeValues;

public class AppointmentTypeDTO {
    private long id;
    private AppointmentTypeValues appointmentTypeValue;
    
	public AppointmentTypeDTO() {
	}
	
	public AppointmentTypeDTO(AppointmentType appointmentType) {
		this(appointmentType.getId(), appointmentType.getAppointmentTypeValue());
	}
	
	public AppointmentTypeDTO(long id, AppointmentTypeValues appointmentTypeValue) {
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
