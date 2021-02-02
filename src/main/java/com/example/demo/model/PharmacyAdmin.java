package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

public class PharmacyAdmin extends User{
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Pharmacy> pharmacies;

    public PharmacyAdmin() {
        super();
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PharmacyAdmin that = (PharmacyAdmin) o;
        return Objects.equals(pharmacies, that.pharmacies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pharmacies);
    }

    @Override
    public String toString() {
        return "PharmacyAdmin{" +
                "pharmacies=" + pharmacies +
                '}';
    }
}
