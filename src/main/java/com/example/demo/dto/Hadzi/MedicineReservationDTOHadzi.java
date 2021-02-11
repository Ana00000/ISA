package com.example.demo.dto.Hadzi;

import com.example.demo.model.MedicineReservation;
import com.example.demo.model.Patient;
import com.example.demo.model.enums.MedicineReservationStatusValue;

import java.io.Serializable;
import java.util.Date;

public class MedicineReservationDTOHadzi implements Serializable {
    private Long id;

    private MedicineReservationStatusValue reservationStatus;

    private Long quantity;

    private String patientName;

    private String patientLastName;

    private Date pickUpDate;

    private String pharmacyName;

    private String medicineName;

    private Long pharmacyID;

    private Long medicineID;

    public MedicineReservationDTOHadzi() {

    }

    public MedicineReservationDTOHadzi(MedicineReservation reservation) {
        this.id = reservation.getId();
        this.reservationStatus = reservation.getReservationStatus();
        this.quantity = reservation.getQuantity();
        this.patientName = reservation.getPatient().getName();
        this.patientLastName = reservation.getPatient().getLastName();
        this.pickUpDate = reservation.getPickUpDate();
        this.pharmacyName = reservation.getPharmacy().getName();
        this.medicineName = reservation.getMedicine().getName();
        this.pharmacyID = reservation.getPharmacy().getId();
        this.medicineID = reservation.getMedicine().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicineReservationStatusValue getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(MedicineReservationStatusValue reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Long getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(Long pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public Long getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(Long medicineID) {
        this.medicineID = medicineID;
    }
}
