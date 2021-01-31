package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.AppointmentTypeValues;

@Entity
public class AppointmentType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    
    @Column(name="appointmentTypeValue", unique=false, nullable=false)
    private AppointmentTypeValues appointmentTypeValue;

    public AppointmentType() {
    }
    
	public AppointmentType(Long id, AppointmentTypeValues appointmentTypeValue) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentTypeValue == null) ? 0 : appointmentTypeValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentType other = (AppointmentType) obj;
		if (appointmentTypeValue != other.appointmentTypeValue)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppointmentType [id=" + id + ", appointmentTypeValue=" + appointmentTypeValue + "]";
	}
}
