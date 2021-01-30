package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Allergy {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicineIngredient medicineIngredient;

    public Allergy() {
    }

	public Allergy(Long id, MedicineIngredient medicineIngredient) {
		super();
		this.id = id;
		this.medicineIngredient = medicineIngredient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicineIngredient getMedicineIngredient() {
		return medicineIngredient;
	}

	public void setMedicineIngredient(MedicineIngredient medicineIngredient) {
		this.medicineIngredient = medicineIngredient;
	}
}
