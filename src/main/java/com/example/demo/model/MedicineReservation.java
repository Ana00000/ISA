package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MedicineReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicineReservationStatus reservationStatus;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PharmacyMedicine pharmacyMedicine;

    public MedicineReservation(Long id) {
        this.id = id;
    }

    public MedicineReservation(Long id, MedicineReservationStatus reservationStatus, Long quantity, Patient patient, PharmacyMedicine pharmacyMedicine) {
        this.id = id;
        this.reservationStatus = reservationStatus;
        this.quantity = quantity;
        this.patient = patient;
        this.pharmacyMedicine = pharmacyMedicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicineReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(MedicineReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PharmacyMedicine getPharmacyMedicine() {
        return pharmacyMedicine;
    }

    public void setPharmacyMedicine(PharmacyMedicine pharmacyMedicine) {
        this.pharmacyMedicine = pharmacyMedicine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineReservation that = (MedicineReservation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(reservationStatus, that.reservationStatus) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(pharmacyMedicine, that.pharmacyMedicine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationStatus, quantity, patient, pharmacyMedicine);
    }

    @Override
    public String toString() {
        return "MedicineReservation{" +
                "id=" + id +
                ", reservationStatus=" + reservationStatus +
                ", quantity=" + quantity +
                ", patient=" + patient +
                ", pharmacyMedicine=" + pharmacyMedicine +
                '}';
    }
}
