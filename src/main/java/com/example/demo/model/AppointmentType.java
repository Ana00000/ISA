/**
 * Class AppointmentType
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

enum AppointmentTypeValues {CONSULTATION, EXAMINATION}

@Entity
//@Table(name="AppointmentType")
public class AppointmentType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This strategy increments key like 1,2,3
    private int typeID;
    @Column(name="typeValue", unique=true, nullable=false)
    private AppointmentTypeValues typeValue;

    public AppointmentType() {
    }

    public AppointmentType(int typeID, AppointmentTypeValues typeValue) {
        this.typeID = typeID;
        this.typeValue = typeValue;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public AppointmentTypeValues getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(AppointmentTypeValues typeValue) {
        this.typeValue = typeValue;
    }
}
