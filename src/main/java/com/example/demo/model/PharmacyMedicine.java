package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(PharmacyMedicinePK.class)
public class PharmacyMedicine {
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Medicine medicine;
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pharmacy pharmacy;
    @Column( nullable = false, unique = false)
    private Long quantity;

    public PharmacyMedicine(){

    }

    public PharmacyMedicine(Medicine medicine, Pharmacy pharmacy, Long quantity) {
        this.medicine = medicine;
        this.pharmacy = pharmacy;
        this.quantity = quantity;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyMedicine that = (PharmacyMedicine) o;
        return Objects.equals(medicine, that.medicine) &&
                Objects.equals(pharmacy, that.pharmacy) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicine, pharmacy, quantity);
    }

    @Override
    public String toString() {
        return "PharmacyMedicine{" +
                "medicine=" + medicine +
                ", pharmacy=" + pharmacy +
                ", quantity=" + quantity +
                '}';
    }
}
