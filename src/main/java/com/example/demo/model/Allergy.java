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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicineIngredient == null) ? 0 : medicineIngredient.hashCode());
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
		Allergy other = (Allergy) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicineIngredient == null) {
			if (other.medicineIngredient != null)
				return false;
		} else if (!medicineIngredient.equals(other.medicineIngredient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Allergy [id=" + id + ", medicineIngredient=" + medicineIngredient + "]";
	}
}
