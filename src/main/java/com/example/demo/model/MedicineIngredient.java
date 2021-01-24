/**
 * Class MedicineIngredient
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

@Entity
public class MedicineIngredient {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int ingredientID;

    @Column(nullable = false)
    private String ingredientName;

    public MedicineIngredient() {
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
