package com.example.demo.dto;

import java.io.Serializable;
import com.example.demo.model.Patient;

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
