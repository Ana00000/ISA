package com.example.demo.dto;

import com.example.demo.model.Grade;
import java.io.Serializable;

public class GradeDTO implements Serializable {

    private Long id;

    private Long userId;

    private Long pharmacyId;

    private int value;

    public GradeDTO() {
    }

    public GradeDTO(Grade grade) {
        this.id = grade.getId();
        this.userId = grade.getUserId();
        this.pharmacyId = grade.getPharmacyId();
        this.value = grade.getValue();
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
