package com.example.demo.model;

import com.example.demo.dto.MedicineReservationDTO;
import com.example.demo.model.enums.MedicineReservationStatusValue;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class MedicineReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MedicineReservationStatusValue reservationStatus;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Medicine medicine;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

    @Column(nullable = false)
    private Date pickUpDate;

    public MedicineReservation(){
    }

    public MedicineReservation(MedicineReservationDTO reservationDTO) {
        this.reservationStatus = reservationDTO.getReservationStatus();
        this.quantity = reservationDTO.getQuantity();
        this.patient = reservationDTO.getPatient();
        this.pharmacy = new Pharmacy(reservationDTO.getPharmacyDTO());
        this.medicine = new Medicine(reservationDTO.getMedicineDTO());
        this.pickUpDate = reservationDTO.getPickUpDate();
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineReservation that = (MedicineReservation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(reservationStatus, that.reservationStatus) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationStatus, quantity, patient);
    }

    @Override
    public String toString() {
        return "MedicineReservation{" +
                "id=" + id +
                ", reservationStatus=" + reservationStatus +
                ", quantity=" + quantity +
                ", patient=" + patient +
                '}';
    }
}
