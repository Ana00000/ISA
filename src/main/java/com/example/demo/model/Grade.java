package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Grade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="userId", unique=false, nullable=false)
    private Long userId;

    @Column(name="pharmacyId", unique=false, nullable=false)
    private Long pharmacyId;

    @Column(name="value", unique=false, nullable=false)
    private int value;

    public Grade(Long userId, Long pharmacyId, int value) {
        this.userId = userId;
        this.pharmacyId = pharmacyId;
        this.value = value;
    }

    public Grade() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
