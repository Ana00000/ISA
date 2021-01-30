package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.MedicineType;

@Entity
public class TypeOfMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="value", unique=false, nullable=false)
    private MedicineType value;

    public TypeOfMedicine() {
    }
    
	public TypeOfMedicine(long id, MedicineType value) {
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
