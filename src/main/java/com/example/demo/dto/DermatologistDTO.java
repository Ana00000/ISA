package com.example.demo.dto;

import com.example.demo.model.Doctor;

public class DermatologistDTO extends DoctorDTO {
	public DermatologistDTO() {
	}
	
	public DermatologistDTO(Doctor doctor) {
		super(doctor, doctor.getType());
	}
}
