package com.example.demo.model;

import com.example.demo.model.enums.MedicineReservationStatusValue;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MedicineReservationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="statusValue", unique = true, nullable = false)
    private MedicineReservationStatusValue statusValue;

    public MedicineReservationStatus(Long id, MedicineReservationStatusValue statusValue) {
        this.id = id;
        this.statusValue = statusValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicineReservationStatusValue getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(MedicineReservationStatusValue statusValue) {
        this.statusValue = statusValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineReservationStatus that = (MedicineReservationStatus) o;
        return Objects.equals(id, that.id) &&
                statusValue == that.statusValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusValue);
    }

    @Override
    public String toString() {
        return "MedicineReservationStatus{" +
                "id=" + id +
                ", statusValue=" + statusValue +
                '}';
    }
}
