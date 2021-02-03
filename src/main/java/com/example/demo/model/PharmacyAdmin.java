package com.example.demo.model;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class PharmacyAdmin extends User{

    public PharmacyAdmin() {
        super();
    }

    @Override
    public String toString() {
        return "PharmacyAdmin{}";
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Pharmacy pharmacy;
}
