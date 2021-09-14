package com.example.demo.dto;

public class BuyMedicineForRecipeDTO {
    private Long recipeId;
    private Long pharmacyId;

    public BuyMedicineForRecipeDTO(){}

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
}
