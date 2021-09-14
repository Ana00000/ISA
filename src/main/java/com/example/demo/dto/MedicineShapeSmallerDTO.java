package com.example.demo.dto;

import com.example.demo.model.MedicineShape;

public class MedicineShapeSmallerDTO {
    private Long id;
    private String name;

    public MedicineShapeSmallerDTO(){}

    public MedicineShapeSmallerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MedicineShapeSmallerDTO(MedicineShape medicineShape){
        this.id = medicineShape.getId();
        this.name = medicineShape.getShapeValue().getText();
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
}
