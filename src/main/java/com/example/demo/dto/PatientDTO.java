package com.example.demo.dto;

import com.example.demo.model.User;

import java.io.Serializable;

public class PatientDTO extends UserDTO implements Serializable {

	public PatientDTO() {
	}

	public PatientDTO(User user) {
		super(user);
	}
}
