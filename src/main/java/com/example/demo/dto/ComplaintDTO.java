package com.example.demo.dto;

import com.example.demo.model.Complaint;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Pharmacy;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ComplaintDTO implements Serializable {
    private Long id;
    private String text;
    private Long pharmacyID;
    private String pharmacyName;
    private Long doctorID;
    private String doctorName;
    private Long patientID;
    private String patientName;
    private String type; //doctor or pharmacy

    public ComplaintDTO(){}
    public ComplaintDTO(Complaint complaint){
        this.id = complaint.getId();
        this.text = complaint.getText();
        if(complaint.getPharmacy()!=null){
            this.pharmacyID = complaint.getPharmacy().getId();
            this.pharmacyName = complaint.getPharmacy().getName();
        }
        if(complaint.getDoctor() != null){
            this.doctorID = complaint.getDoctor().getId();
            this.doctorName = complaint.getDoctor().getName();
        }
        if(complaint.getPatient()!=null){
            this.patientID = complaint.getPatient().getId();
            this.patientName = complaint.getPatient().getName();
        }

    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(Long pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
