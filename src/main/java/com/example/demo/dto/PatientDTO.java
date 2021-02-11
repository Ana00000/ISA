package com.example.demo.dto;

import com.example.demo.model.Patient;
import com.example.demo.model.User;

import java.io.Serializable;

public class PatientDTO extends UserDTO implements Serializable {
	
	private int penalties;

	public PatientDTO() {
	}

	public PatientDTO(Patient patient) {
		super(patient);
		this.penalties = patient.getPenalties();
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

}
