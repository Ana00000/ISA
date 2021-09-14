package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.example.demo.dto.PharmacyAdminDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class PharmacyAdmin extends User{

    public PharmacyAdmin() {
        super();
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Pharmacy pharmacy;

    public PharmacyAdmin(PharmacyAdminDTO pharmacyAdminDTO, Pharmacy pharmacy) {
        super(pharmacyAdminDTO);
        this.pharmacy = pharmacy;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public String toString() {
        return "PharmacyAdmin{" +
                "pharmacy=" + pharmacy +
                '}';
    }
}
