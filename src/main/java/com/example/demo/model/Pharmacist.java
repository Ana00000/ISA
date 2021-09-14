package com.example.demo.model;

import com.example.demo.dto.PharmacistDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Pharmacist extends Doctor {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pharmacy_id", referencedColumnName = "id")
    @JsonManagedReference //this will be serialized
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