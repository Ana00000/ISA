/**
 * Class MedicineShape
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

enum MedicineShapeValue { pill, tablet, syrup }

@Entity
public class MedicineShape {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int shapeID;

    @Column( nullable = false )
    private MedicineShapeValue medicineShapeValue;

    public MedicineShape() {
    }

    public int getShapeID() {
        return shapeID;
    }

    public void setShapeID(int shapeID) {
        this.shapeID = shapeID;
    }

    public MedicineShapeValue getMedicineShapeValue() {
        return medicineShapeValue;
    }

    public void setMedicineShapeValue(MedicineShapeValue medicineShapeValue) {
        this.medicineShapeValue = medicineShapeValue;
    }
}
