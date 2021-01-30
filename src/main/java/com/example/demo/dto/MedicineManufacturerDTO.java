package com.example.demo.dto;

import com.example.demo.model.MedicineManufacturer;

public class MedicineManufacturerDTO {
	private long id;
    private String name;
    
	public MedicineManufacturerDTO() {
	}
	
	public MedicineManufacturerDTO(MedicineManufacturer medicineManufacturer) {
		this(medicineManufacturer.getId(), medicineManufacturer.getName());
	}

	public MedicineManufacturerDTO(long id, String name) {
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
