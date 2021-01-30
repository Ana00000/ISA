package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicineIngredient medicineIngredient;

    public Allergy() {
    }

	public Allergy(long id, MedicineIngredient medicineIngredient) {
		super();
		this.id = id;
		this.medicineIngredient = medicineIngredient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MedicineIngredient getMedicineIngredient() {
		return medicineIngredient;
	}

	public void setMedicineIngredient(MedicineIngredient medicineIngredient) {
		this.medicineIngredient = medicineIngredient;
	}
}
