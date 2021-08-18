package com.example.demo.model;

import com.example.demo.dto.DermatologistDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Dermatologist")
public class Dermatologist extends Doctor {
	
	 public Dermatologist(){
	 }

	 public  Dermatologist(DermatologistDTO dermatologistDTO){
	 	super(dermatologistDTO);
	 }

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dermatologists")
	private Set<Pharmacy> pharmacies = new HashSet<>();
}
