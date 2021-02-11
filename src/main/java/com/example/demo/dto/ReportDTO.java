package com.example.demo.dto;

import java.sql.Timestamp;
import com.example.demo.model.Report;

public class ReportDTO {
	private Long id;
	private MedicineDTO medicine;
	private PatientDTO patient;
	private DoctorDTO doctor;
	private Timestamp startTime;
	private Timestamp endTime;
	private int therapyInDays;
	private String description;
	 
	public ReportDTO() {
	}
	
	public ReportDTO(Report report) {
		this.id = report.getId();
		
		if (report.getMedicine() != null)
			this.medicine = new MedicineDTO(report.getMedicine());
		if (report.getPatient() != null) 
			this.patient = new PatientDTO(report.getPatient());
		if (report.getDoctor() != null) 
			this.doctor = new DoctorDTO(report.getDoctor(), report.getDoctor().getType());

		this.startTime = report.getStartTime();
		this.endTime = report.getEndTime();
		this.therapyInDays = report.getTherapyInDays();
		this.description = report.getDescription();
	}

	public ReportDTO(Long id, MedicineDTO medicine,	PatientDTO patient,
			DoctorDTO doctor, Timestamp startTime, Timestamp endTime, 
			int therapyInDays, String description) {
		super();
		this.id = id;
		this.medicine = medicine;
		this.patient = patient;
		this.doctor = doctor;
		this.startTime = startTime;
		this.endTime = endTime;
		this.therapyInDays = therapyInDays;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicineDTO getMedicine() {
		return medicine;
	}

	public void setMedicine(MedicineDTO medicine) {
		this.medicine = medicine;
	}

	public PatientDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientDTO patient) {
		this.patient = patient;
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
	
	public int getTherapyInDays() {
		return therapyInDays;
	}

	public void setTherapyInDays(int therapyInDays) {
		this.therapyInDays = therapyInDays;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}