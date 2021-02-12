package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineIngredient;

public class MedicineDTO implements Serializable {
    private Long id;
    private String name;
    private boolean recipeNeed;
    private MedicineManufacturerDTO medicineManufacturer;
    private MedicineShapeDTO medicineShape;
    private List<MedicineIngredientDTO> medicinesIngredients;
    private int quantity;

	public MedicineDTO() {
	}
	
	public MedicineDTO(Medicine medicine) {
		this.id = medicine.getId();
		this.name = medicine.getName();
		this.recipeNeed = medicine.isRecipeNeeded();
		this.medicineManufacturer = new MedicineManufacturerDTO(medicine.getMedicineManufacturer());
		this.medicineShape = new MedicineShapeDTO(medicine.getMedicineShape());

		List<MedicineIngredientDTO> medicinesIngredients = new ArrayList<MedicineIngredientDTO>();
        for(MedicineIngredient mi: medicine.getIngredients())
        	medicinesIngredients.add(new MedicineIngredientDTO(mi));
        this.medicinesIngredients = medicinesIngredients;
	}
	
	public MedicineDTO(Long id, String name, boolean recipeNeed, MedicineManufacturerDTO medicineManufacturer,
			MedicineShapeDTO medicineShape, List<MedicineIngredientDTO> medicinesIngredients, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.recipeNeed = recipeNeed;
		this.medicineManufacturer = medicineManufacturer;
		this.medicineShape = medicineShape;
		this.medicinesIngredients = medicinesIngredients;
		this.quantity = quantity;
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
	
	public void setMedicineManufacturer(MedicineManufacturerDTO medicineManufacturer) { this.medicineManufacturer = medicineManufacturer; }
	
	public MedicineShapeDTO getMedicineShape() {
		return medicineShape;
	}
	
	public void setMedicineShape(MedicineShapeDTO medicineShape) {
		this.medicineShape = medicineShape;
	}

	public List<MedicineIngredientDTO> getMedicinesIngredients() {
		return medicinesIngredients;
	}

	public void setMedicinesIngredients(List<MedicineIngredientDTO> medicinesIngredients) {
		this.medicinesIngredients = medicinesIngredients;
	}

	public int getQuantity() { return quantity; }

	public void setQuantity(int quantity) { this.quantity = quantity; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicineManufacturer == null) ? 0 : medicineManufacturer.hashCode());
		result = prime * result + ((medicineShape == null) ? 0 : medicineShape.hashCode());
		result = prime * result + ((medicinesIngredients == null) ? 0 : medicinesIngredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (recipeNeed ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicineDTO other = (MedicineDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicineManufacturer == null) {
			if (other.medicineManufacturer != null)
				return false;
		} else if (!medicineManufacturer.equals(other.medicineManufacturer))
			return false;
		if (medicineShape == null) {
			if (other.medicineShape != null)
				return false;
		} else if (!medicineShape.equals(other.medicineShape))
			return false;
		if (medicinesIngredients == null) {
			if (other.medicinesIngredients != null)
				return false;
		} else if (!medicinesIngredients.equals(other.medicinesIngredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipeNeed != other.recipeNeed)
			return false;
		return true;
	}
}
