package com.example.demo.dto;

import com.example.demo.model.MedicineShape;
import com.example.demo.model.enums.MedicineShapeValue;

public class MedicineShapeDTO 
{
	private long id;
	private MedicineShapeValue value;
	 
	public MedicineShapeDTO() {
	}
	
	public MedicineShapeDTO(MedicineShape medicineShape) {
		this(medicineShape.getId(), medicineShape.getValue());
	}

	public MedicineShapeDTO(long id, MedicineShapeValue value) {
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

	public MedicineShapeValue getValue() {
		return value;
	}

	public void setValue(MedicineShapeValue value) {
		this.value = value;
	}
}
