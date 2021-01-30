package com.example.demo.dto;

import com.example.demo.model.MedicineIngredient;

public class MedicineIngredientDTO {
    private Long id;
    private String name;
    
	public MedicineIngredientDTO() {
	}
	
	public MedicineIngredientDTO(MedicineIngredient medicineIngredient) {
		this(medicineIngredient.getId(), medicineIngredient.getName());
	}

	public MedicineIngredientDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
