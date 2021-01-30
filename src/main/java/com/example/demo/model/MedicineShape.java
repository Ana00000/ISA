package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.MedicineShapeValue;

@Entity
public class MedicineShape {
	
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
}
