package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.MedicineShapeValue;

@Entity
public class MedicineShape 
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="value", unique=false, nullable=false)
    private MedicineShapeValue value;

    public MedicineShape() {
    }
    
	public MedicineShape(long id, MedicineShapeValue value) {
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
