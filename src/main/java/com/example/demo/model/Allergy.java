/**
 * Class Allergy
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int allergyID;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    MedicineIngredient medicineIngredient;

    public Allergy() {
    }

    public int getAllergyID() {
        return allergyID;
    }

    public void setAllergyID(int allergyID) {
        this.allergyID = allergyID;
    }

    public MedicineIngredient getMedicineIngredient() {
        return medicineIngredient;
    }

    public void setMedicineIngredient(MedicineIngredient medicineIngredient) {
        this.medicineIngredient = medicineIngredient;
    }
}
