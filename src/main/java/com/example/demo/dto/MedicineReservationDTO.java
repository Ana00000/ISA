package com.example.demo.dto;

import com.example.demo.model.MedicineReservation;
import com.example.demo.model.MedicineReservationStatus;
import com.example.demo.model.Patient;
import com.example.demo.model.PharmacyMedicine;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

public class MedicineReservationDTO {
    private MedicineReservationStatus reservationStatus;

    private Long quantity;

    private Patient patient;

    private PharmacyDTO pharmacyDTO;

    private MedicineDTO medicineDTO;

    public MedicineReservationDTO() {}

    public MedicineReservationDTO(MedicineReservation reservation) {
        this.reservationStatus = reservation.getReservationStatus();
        this.quantity = reservation.getQuantity();
        this.patient = reservation.getPatient();
        this.pharmacyDTO = new PharmacyDTO(reservation.getPharmacyMedicine().getPharmacy());
        this.medicineDTO = new MedicineDTO(reservation.getPharmacyMedicine().getMedicine());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineReservationDTO that = (MedicineReservationDTO) o;
        return Objects.equals(reservationStatus, that.reservationStatus) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(pharmacyDTO, that.pharmacyDTO) &&
                Objects.equals(medicineDTO, that.medicineDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationStatus, quantity, patient, pharmacyDTO, medicineDTO);
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
