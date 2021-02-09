package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Pharmacist extends Doctor {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

	public Pharmacist(){
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
