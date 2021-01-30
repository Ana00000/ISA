package com.example.demo.model;

import javax.persistence.*;

@Entity
public class MedicineManufacturer {
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    
    @Column(name="name", unique=false, nullable=false)
    private String name;

    public MedicineManufacturer() {
    }
   
	public MedicineManufacturer(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
