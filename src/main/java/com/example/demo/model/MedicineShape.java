package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.MedicineShapeValue;

import java.io.Serializable;

@Entity
public class MedicineShape implements Serializable {
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    
    @Column(name="shapeValue", unique=false, nullable=false)
    private MedicineShapeValue shapeValue;

    public MedicineShape() {
    }
    
	public MedicineShape(Long id, MedicineShapeValue shapeValue) {
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
		MedicineShape other = (MedicineShape) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shapeValue != other.shapeValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicineShape [id=" + id + ", shapeValue=" + shapeValue + "]";
	}
}
