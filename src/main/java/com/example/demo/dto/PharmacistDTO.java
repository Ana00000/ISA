package com.example.demo.dto;

import com.example.demo.model.Doctor;
import com.example.demo.model.Pharmacist;

public class PharmacistDTO extends DoctorDTO {
	private String pharmacyName;

	public PharmacistDTO() {
	}

	public PharmacistDTO(Doctor doctor) {
		super(doctor, doctor.getType());
	}

	public PharmacistDTO(Pharmacist pharmacist){
		super(pharmacist);
		pharmacyName = pharmacist.getPharmacy().getName();
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
}