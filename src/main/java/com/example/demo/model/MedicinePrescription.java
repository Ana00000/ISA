package com.example.demo.model;

import com.example.demo.model.enums.PrescriptionStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicinePrescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY )
    private Medicine medicine;

    @ManyToOne( fetch = FetchType.LAZY )
    private Patient patient;

    @ManyToOne( fetch = FetchType.LAZY )
    private Doctor doctor;

    @Column(nullable = false, name = "local_date")
    private LocalDate date;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private PrescriptionStatus prescriptionStatus;

    public MedicinePrescription(Long id, Medicine medicine, Patient patient, Doctor doctor, LocalDate date, PrescriptionStatus prescriptionStatus) {
        this.id = id;
        this.medicine = medicine;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.prescriptionStatus = prescriptionStatus;
    }

    public MedicinePrescription(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
