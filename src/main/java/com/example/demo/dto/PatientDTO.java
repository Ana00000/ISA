package com.example.demo.dto;

import com.example.demo.model.Patient;
import com.example.demo.model.User;

import java.io.Serializable;

public class PatientDTO extends UserDTO implements Serializable {
	private Long penalties;

	public PatientDTO() {
	}

	public PatientDTO(Patient patient) {
		super(patient);
		this.penalties = patient.getPenalties();
	}

	public Long getPenalties() {
		return penalties;
	}

	public void setPenalties(Long penalties) {
		this.penalties = penalties;
	}
}
