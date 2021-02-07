package com.example.demo.dto;

import java.sql.Timestamp;
import com.example.demo.model.Vacation;
import com.example.demo.model.enums.VacationStatusValue;

public class VacationDTO {
	private Long id;
	private VacationStatusValue status;
	private DoctorDTO doctor;
	private Timestamp startTime;
	private Timestamp endTime;
	
	public VacationDTO() {
	}
	
	public VacationDTO(Vacation vacation) {
		this.id = vacation.getId();
		this.status = vacation.getStatus();
		this.doctor = new DoctorDTO(vacation.getDoctor(), vacation.getDoctor().getType());
		this.startTime = vacation.getStartTime();
		this.endTime = vacation.getEndTime();
	}

	public VacationDTO(Long id, VacationStatusValue status, DoctorDTO doctor, Timestamp startTime, Timestamp endTime) {
		super();
		this.id = id;
		this.status = status;
		this.doctor = doctor;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VacationStatusValue getStatus() {
		return status;
	}

	public void setStatus(VacationStatusValue status) {
		this.status = status;
	}

	public DoctorDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDTO doctor) {
		this.doctor = doctor;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}
