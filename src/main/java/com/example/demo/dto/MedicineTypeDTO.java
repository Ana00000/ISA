package com.example.demo.dto;

import com.example.demo.model.MedicineType;

public class MedicineTypeDTO {
    private Long id;

    private String type;

    public MedicineTypeDTO(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public MedicineTypeDTO(MedicineType medicineType){
        this.id = medicineType.getId();
        this.type = medicineType.getType();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
