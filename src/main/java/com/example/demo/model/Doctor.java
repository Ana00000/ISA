package com.example.demo.model;

import com.example.demo.dto.DoctorDTO;

import javax.persistence.*;

@Entity
public class Doctor extends User {
	
	@Column(name="type", unique=false, nullable=false)
	private String type;
	
    public Doctor(){
    }

	public Doctor(String type) {
		super();
		this.type = type;
	}

	public Doctor(DoctorDTO doctorDTO) {
		super(doctorDTO);
		this.type = doctorDTO.getType();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [type=" + type + "]" + super.toString();
	}


}
