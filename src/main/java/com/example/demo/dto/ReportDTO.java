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
	}

	public ReportDTO(Long id, MedicineDTO medicine,	PatientDTO patient,
			DoctorDTO doctor, Timestamp startTime, Timestamp endTime) {
		super();
		this.id = id;
		this.medicine = medicine;
		this.patient = patient;
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
}