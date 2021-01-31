package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.model.enums.MedicineType;

@Entity
public class TypeOfMedicine {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    
    @Column(name="medicineType", unique=false, nullable=false)
    private MedicineType medicineType;

    public TypeOfMedicine() {
    }
    
	public TypeOfMedicine(Long id, MedicineType medicineType) {
		super();
		this.id = id;
		this.medicineType = medicineType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicineType getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(MedicineType medicineType) {
		this.medicineType = medicineType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicineType == null) ? 0 : medicineType.hashCode());
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
		TypeOfMedicine other = (TypeOfMedicine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicineType != other.medicineType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypeOfMedicine [id=" + id + ", medicineType=" + medicineType + "]";
	}
}
