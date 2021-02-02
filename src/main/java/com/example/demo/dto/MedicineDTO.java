package com.example.demo.dto;

import com.example.demo.model.Medicine;

import java.io.Serializable;

public class MedicineDTO implements Serializable {
    private Long id;
    private String name;
    private boolean recipeNeed;
    private MedicineManufacturerDTO medicineManufacturer;
    private MedicineShapeDTO medicineShape;
    
	public MedicineDTO() {
	}
	
	public MedicineDTO(Medicine medicine) {
		this.id = medicine.getId();
		this.name = medicine.getName();
		this.recipeNeed = medicine.isRecipeNeeded();
		this.medicineManufacturer = new MedicineManufacturerDTO(medicine.getMedicineManufacturer());
		this.medicineShape = new MedicineShapeDTO(medicine.getMedicineShape());
	}
	
	public MedicineDTO(Long id, String name, boolean recipeNeed, MedicineManufacturerDTO medicineManufacturer,
			MedicineShapeDTO medicineShape) {
		super();
		this.id = id;
		this.name = name;
		this.recipeNeed = recipeNeed;
		this.medicineManufacturer = medicineManufacturer;
		this.medicineShape = medicineShape;
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
	
	public MedicineManufacturerDTO getMedicineManufacturer() {
		return medicineManufacturer;
	}
	
	public void setMedicineManufacturer(MedicineManufacturerDTO medicineManufacturer) {
		this.medicineManufacturer = medicineManufacturer;
	}
	
	public MedicineShapeDTO getMedicineShape() {
		return medicineShape;
	}
	
	public void setMedicineShape(MedicineShapeDTO medicineShape) {
		this.medicineShape = medicineShape;
	}
}
