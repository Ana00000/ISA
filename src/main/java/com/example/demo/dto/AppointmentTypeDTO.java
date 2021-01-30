package com.example.demo.dto;

import com.example.demo.model.AppointmentType;
import com.example.demo.model.enums.AppointmentTypeValues;

public class AppointmentTypeDTO {
    private long id;
    private AppointmentTypeValues value;
    
	public AppointmentTypeDTO() {
	}
	
	public AppointmentTypeDTO(AppointmentType appointmentType) {
		this(appointmentType.getId(), appointmentType.getValue());
	}
	
	public AppointmentTypeDTO(long id, AppointmentTypeValues value) {
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
