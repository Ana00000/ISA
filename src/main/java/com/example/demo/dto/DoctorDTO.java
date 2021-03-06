package com.example.demo.dto;
import com.example.demo.model.Doctor;
import com.example.demo.model.User;

public class DoctorDTO extends UserDTO {
	
	private String type;
	
	public DoctorDTO() {
	}
	
	public DoctorDTO(User user, String type) {
		super(user);
		this.type = type;
	}

	public DoctorDTO(Doctor doctor){
		super(doctor);
		this.type = doctor.getType();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DoctorDTO [type=" + type + "]";
	}
}
