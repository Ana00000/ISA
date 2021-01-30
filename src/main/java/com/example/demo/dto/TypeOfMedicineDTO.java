package com.example.demo.dto;

import com.example.demo.model.TypeOfMedicine;
import com.example.demo.model.enums.MedicineType;

public class TypeOfMedicineDTO {
	private long id;
	private MedicineType value;
	
	public TypeOfMedicineDTO() {
	}
	
	public TypeOfMedicineDTO(TypeOfMedicine typeOfMedicine) {
		this(typeOfMedicine.getId(), typeOfMedicine.getValue());
	}

	public TypeOfMedicineDTO(long id, MedicineType value) {
		super();
		this.id = id;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MedicineType getValue() {
		return value;
	}

	public void setValue(MedicineType value) {
		this.value = value;
	}
}
