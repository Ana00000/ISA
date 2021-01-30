package com.example.demo.dto;

import com.example.demo.model.TypeOfMedicine;
import com.example.demo.model.enums.MedicineType;

public class TypeOfMedicineDTO {
	private long id;
	private MedicineType medicineType;
	
	public TypeOfMedicineDTO() {
	}
	
	public TypeOfMedicineDTO(TypeOfMedicine typeOfMedicine) {
		this(typeOfMedicine.getId(), typeOfMedicine.getMedicineType());
	}

	public TypeOfMedicineDTO(long id, MedicineType medicineType) {
		super();
		this.id = id;
		this.medicineType = medicineType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MedicineType getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(MedicineType medicineType) {
		this.medicineType = medicineType;
	}
}
