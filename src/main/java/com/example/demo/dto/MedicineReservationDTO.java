package com.example.demo.dto;

import com.example.demo.model.MedicineReservation;
import com.example.demo.model.MedicineReservationStatus;
import com.example.demo.model.Patient;

import java.util.Date;
import java.util.Objects;

public class MedicineReservationDTO {

    private Long id;

    private MedicineReservationStatus reservationStatus;

    private Long quantity;

    private Patient patient;

    private PharmacyDTO pharmacyDTO;

    private MedicineDTO medicineDTO;

    private Date pickUpDate;

    public MedicineReservationDTO() {}

    public MedicineReservationDTO(MedicineReservation reservation) {
        this.id = reservation.getId();
        this.reservationStatus = reservation.getReservationStatus();
        this.quantity = reservation.getQuantity();
        this.patient = reservation.getPatient();
        this.pharmacyDTO = new PharmacyDTO(reservation.getPharmacyMedicine().getPharmacy());
        this.medicineDTO = new MedicineDTO(reservation.getPharmacyMedicine().getMedicine());
        this.pickUpDate = reservation.getPickUpDate();
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

    public PharmacyDTO getPharmacyDTO() {
        return pharmacyDTO;
    }

    public void setPharmacyDTO(PharmacyDTO pharmacyDTO) {
        this.pharmacyDTO = pharmacyDTO;
    }

    public MedicineDTO getMedicineDTO() {
        return medicineDTO;
    }

    public void setMedicineDTO(MedicineDTO medicineDTO) {
        this.medicineDTO = medicineDTO;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineReservationDTO that = (MedicineReservationDTO) o;
        return  Objects.equals(id, that.id) &&
                Objects.equals(reservationStatus, that.reservationStatus) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(pharmacyDTO, that.pharmacyDTO) &&
                Objects.equals(medicineDTO, that.medicineDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationStatus, quantity, patient, pharmacyDTO, medicineDTO);
    }

    @Override
    public String toString() {
        return "MedicineReservationDTO{" +
                "reservationStatus=" + reservationStatus +
                ", quantity=" + quantity +
                ", patient=" + patient +
                ", pharmacyDTO=" + pharmacyDTO +
                ", medicineDTO=" + medicineDTO +
                '}';
    }
}
