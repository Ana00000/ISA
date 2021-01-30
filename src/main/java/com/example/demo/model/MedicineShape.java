package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.MedicineShapeValue;

@Entity
public class MedicineShape {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="shapeValue", unique=false, nullable=false)
    private MedicineShapeValue shapeValue;

    public MedicineShape() {
    }
    
	public MedicineShape(long id, MedicineShapeValue shapeValue) {
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
