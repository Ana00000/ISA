package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class PharmacyMedicinePK implements Serializable {
    protected Medicine medicine;
    protected Pharmacy pharmacy;

    public PharmacyMedicinePK() {
    }

    public PharmacyMedicinePK(Medicine medicine, Pharmacy pharmacy) {
        this.medicine = medicine;
        this.pharmacy = pharmacy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyMedicinePK that = (PharmacyMedicinePK) o;
        return Objects.equals(medicine, that.medicine) &&
                Objects.equals(pharmacy, that.pharmacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicine, pharmacy);
    }
}
