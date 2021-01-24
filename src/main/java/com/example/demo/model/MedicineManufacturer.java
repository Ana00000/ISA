/**
 * Class MedicineManufacturer
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

@Entity
public class MedicineManufacturer {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int manufacturerID;

    @Column( nullable = false )
    private String manufacturerName;

    public MedicineManufacturer() {
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
