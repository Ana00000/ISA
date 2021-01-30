package com.example.demo.dto;

import com.example.demo.model.MedicineIngredient;

public class MedicineIngredientDTO 
{
    private long id;
    private String name;
    
	public MedicineIngredientDTO() {
	}
	
	public MedicineIngredientDTO(MedicineIngredient medicineIngredient) {
		this(medicineIngredient.getId(), medicineIngredient.getName());
	}

	public MedicineIngredientDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
