package com.example.demo.dto;

import com.example.demo.model.MedicineShape;
import com.example.demo.model.enums.MedicineShapeValue;

public class MedicineShapeDTO {
	private Long id;
	private MedicineShapeValue shapeValue;
	 
	public MedicineShapeDTO() {
	}
	
	public MedicineShapeDTO(MedicineShape medicineShape) {
		this(medicineShape.getId(), medicineShape.getShapeValue());
	}

	public MedicineShapeDTO(Long id, MedicineShapeValue shapeValue) {
		super();
		this.id = id;
		this.shapeValue = shapeValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicineShapeValue getShapeValue() {
		return shapeValue;
	}

	public void setShapeValue(MedicineShapeValue shapeValue) {
		this.shapeValue = shapeValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((shapeValue == null) ? 0 : shapeValue.hashCode());
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
		MedicineShapeDTO other = (MedicineShapeDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shapeValue != other.shapeValue)
			return false;
		return true;
	}
}
