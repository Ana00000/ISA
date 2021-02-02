package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

public class PharmacyAdmin extends User{

    public PharmacyAdmin() {
        super();
    }

    @Override
    public String toString() {
        return "PharmacyAdmin{}";
    }
}
