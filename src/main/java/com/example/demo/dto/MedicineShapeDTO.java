package com.example.demo.dto;

import com.example.demo.model.MedicineShape;
import com.example.demo.model.enums.MedicineShapeValue;

public class MedicineShapeDTO {
	private long id;
	private MedicineShapeValue shapeValue;
	 
	public MedicineShapeDTO() {
	}
	
	public MedicineShapeDTO(MedicineShape medicineShape) {
		this(medicineShape.getId(), medicineShape.getShapeValue());
	}

	public MedicineShapeDTO(long id, MedicineShapeValue shapeValue) {
		super();
		this.id = id;
		this.shapeValue = shapeValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MedicineShapeValue getShapeValue() {
		return shapeValue;
	}

	public void setShapeValue(MedicineShapeValue shapeValue) {
		this.shapeValue = shapeValue;
	}
}
