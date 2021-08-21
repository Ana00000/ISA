package com.example.demo.dto;

import java.util.List;

public class MedicineToAddDTO {
    private Long id;
    private String name;
    private boolean recipeNeed;
    private String medicineManufacturer;
    private String medicineShape;
    private List<String> medicinesIngredients;
    private List<String> alternativeMedicines;
    private String code;
    private String medicinType;
    private String contraindications;
    private int recommendedIntake;
    private String medicineShapeName;

    public MedicineToAddDTO(){}

    public MedicineToAddDTO(Long id, String name, boolean recipeNeed, String medicineManufacturer,
                            String medicineShape, List<String> medicinesIngredients, List<String> alternativeMedicines,
                            String code, String medicinType, String contraindications, int recommendedIntake, String medicineShapeName) {
        this.id = id;
        this.name = name;
        this.recipeNeed = recipeNeed;
        this.medicineManufacturer = medicineManufacturer;
        this.medicineShape = medicineShape;
        this.medicinesIngredients = medicinesIngredients;
        this.alternativeMedicines = alternativeMedicines;
        this.code = code;
        this.medicinType = medicinType;
        this.contraindications = contraindications;
        this.recommendedIntake = recommendedIntake;
        this.medicineShapeName = medicineShapeName;
    }

    public String getMedicineShapeName() {
        return medicineShapeName;
    }

    public void setMedicineShapeName(String medicineShapeName) {
        this.medicineShapeName = medicineShapeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRecipeNeed() {
        return recipeNeed;
    }

    public void setRecipeNeed(boolean recipeNeed) {
        this.recipeNeed = recipeNeed;
    }

    public String getMedicineManufacturer() {
        return medicineManufacturer;
    }

    public void setMedicineManufacturer(String medicineManufacturer) {
        this.medicineManufacturer = medicineManufacturer;
    }

    public String getMedicineShape() {
        return medicineShape;
    }

    public void setMedicineShape(String medicineShape) {
        this.medicineShape = medicineShape;
    }

    public List<String> getMedicinesIngredients() {
        return medicinesIngredients;
    }

    public void setMedicinesIngredients(List<String> medicinesIngredients) {
        this.medicinesIngredients = medicinesIngredients;
    }

    public List<String> getAlternativeMedicines() {
        return alternativeMedicines;
    }

    public void setAlternativeMedicines(List<String> alternativeMedicines) {
        this.alternativeMedicines = alternativeMedicines;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMedicinType() {
        return medicinType;
    }

    public void setMedicinType(String medicinType) {
        this.medicinType = medicinType;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public int getRecommendedIntake() {
        return recommendedIntake;
    }

    public void setRecommendedIntake(int recommendedIntake) {
        this.recommendedIntake = recommendedIntake;
    }
}
