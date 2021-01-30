package com.example.demo.dto;

import com.example.demo.model.Allergy;

public class AllergyDTO {
	private Long id;
	private MedicineIngredientDTO medicineIngredient;
	
	public AllergyDTO() {
	}
	
	public AllergyDTO(Allergy allergy) {
		this.id = allergy.getId();
		this.medicineIngredient = new MedicineIngredientDTO(allergy.getMedicineIngredient());
	}
	
	public AllergyDTO(Long id, MedicineIngredientDTO medicineIngredient) {
		super();
		this.id = id;
		this.medicineIngredient = medicineIngredient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicineIngredientDTO getMedicineIngredient() {
		return medicineIngredient;
	}

	public void setMedicineIngredient(MedicineIngredientDTO medicineIngredient) {
		this.medicineIngredient = medicineIngredient;
	}
}
