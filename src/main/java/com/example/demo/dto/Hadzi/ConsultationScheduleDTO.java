package com.example.demo.dto.Hadzi;

import com.example.demo.model.TimeInterval;

import java.io.Serializable;

public class ConsultationScheduleDTO implements Serializable {
    private Long pharmacyID;

    private Long pharmacistID;

    private TimeInterval timeInterval;

    public ConsultationScheduleDTO(){

    }

    public Long getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(Long pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public Long getPharmacistID() {
        return pharmacistID;
    }

    public void setPharmacistID(Long pharmacistID) {
        this.pharmacistID = pharmacistID;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }
}
