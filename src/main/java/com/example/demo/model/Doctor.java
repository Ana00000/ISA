package com.example.demo.model;

import javax.persistence.*;

@Entity
public abstract class Doctor extends User {
	@Column(name="type", unique=false, nullable=false)
	private String type;
	
    public Doctor(){
    }

	public Doctor(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
