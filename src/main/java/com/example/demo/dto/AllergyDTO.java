package com.example.demo.dto;

import com.example.demo.model.Allergy;
import com.example.demo.model.MedicineIngredient;

public class AllergyDTO 
{
	private long id;
	private MedicineIngredient medicineIngredient;
	
	public AllergyDTO() {
	}
	
	public AllergyDTO(Allergy allergy) {
		this(allergy.getId(), allergy.getMedicineIngredient());
	}
	
	public AllergyDTO(long id, MedicineIngredient medicineIngredient) {
		super();
		this.id = id;
		this.medicineIngredient = medicineIngredient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MedicineIngredient getMedicineIngredient() {
		return medicineIngredient;
	}

	public void setMedicineIngredient(MedicineIngredient medicineIngredient) {
		this.medicineIngredient = medicineIngredient;
	}
}
