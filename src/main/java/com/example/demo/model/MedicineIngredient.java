package com.example.demo.model;

import javax.persistence.*;

@Entity
public class MedicineIngredient 
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(name="name", unique=false, nullable=false)
    private String name;

    public MedicineIngredient() {
    }

	public MedicineIngredient(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
