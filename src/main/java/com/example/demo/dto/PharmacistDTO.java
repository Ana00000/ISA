package com.example.demo.dto;

import com.example.demo.model.Doctor;
import com.example.demo.model.Pharmacist;
import com.example.demo.model.Pharmacy;

public class PharmacistDTO extends DoctorDTO {

	public PharmacistDTO() {
	}

	public PharmacistDTO(Pharmacist pharmacist){
		this.setId(pharmacist.getId());
		this.setName(pharmacist.getName());
		this.setLastName(pharmacist.getLastName());
	}

	public PharmacistDTO(Doctor doctor) {
		super(doctor, doctor.getType());
	}

}
