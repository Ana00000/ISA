package com.example.demo.model;

import com.example.demo.dto.MedicineIngredientDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MedicineIngredient implements Serializable {
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", unique=false, nullable=false)
    private String name;

    public MedicineIngredient() {
    }

	public MedicineIngredient(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public  MedicineIngredient(MedicineIngredientDTO medicineIngredientDTO){
    	this.id = medicineIngredientDTO.getId();
    	this.name = medicineIngredientDTO.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		MedicineIngredient other = (MedicineIngredient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicineIngredient [id=" + id + ", name=" + name + "]";
	}
}
