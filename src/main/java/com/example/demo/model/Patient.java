package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.dto.UserDTO;

import java.io.Serializable;

@Entity
public class Patient extends User implements Serializable{

    @Column(name = "subscribedToPromotions", unique = false, nullable = false)
    private Boolean subscribedToPromotions;

    public Patient(){
    }
    
    public Patient(UserDTO userDTO) {
    	super(userDTO);
    }
}
