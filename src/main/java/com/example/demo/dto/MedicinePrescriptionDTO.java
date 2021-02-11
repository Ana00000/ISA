package com.example.demo.dto;

import com.example.demo.model.MedicinePrescription;
import com.example.demo.model.enums.PrescriptionStatus;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicinePrescriptionDTO implements Serializable {
    private Long id;

    private String medicineName;

    private String patientName;

    private String patientLastName;

    private String doctorName;

    private String doctorLastName;

    private String doctorType;

    private LocalDate date;

    private PrescriptionStatus prescriptionStatus;

    public MedicinePrescriptionDTO(MedicinePrescription medicinePrescription){
        this.id = medicinePrescription.getId();
        this.medicineName = medicinePrescription.getMedicine().getName();
        this.patientName = medicinePrescription.getPatient().getName();
        this.patientLastName = medicinePrescription.getPatient().getLastName();
        this.doctorName = medicinePrescription.getDoctor().getName();
        this.doctorLastName = medicinePrescription.getDoctor().getLastName();
        this.doctorType = medicinePrescription.getDoctor().getType();
        this.date = medicinePrescription.getDate();
        this.prescriptionStatus = medicinePrescription.getPrescriptionStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PrescriptionStatus getPrescriptionStatus() {
        return prescriptionStatus;
    }

    public void setPrescriptionStatus(PrescriptionStatus prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
    }
}
