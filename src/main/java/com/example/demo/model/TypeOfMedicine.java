package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.MedicineType;

@Entity
public class TypeOfMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;
    
    @Column(name="medicineType", unique=false, nullable=false)
    private MedicineType medicineType;

    public TypeOfMedicine() {
    }
    
	public TypeOfMedicine(long id, MedicineType medicineType) {
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
