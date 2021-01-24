/**
 * Class TypeOfMedicine
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

enum MedicineType { HEAD, BODY}

@Entity
public class TypeOfMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeID;
    @Column(nullable = false)
    private MedicineType typeValue;

    public TypeOfMedicine() {
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public MedicineType getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(MedicineType typeValue) {
        this.typeValue = typeValue;
    }
}
