package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.dto.UserDTO;

import java.io.Serializable;

@Entity
public class Patient extends User implements Serializable{

    @Column(name = "subscribedToPromotions", unique = false, nullable = false)
    private Boolean subscribedToPromotions;

    private Long penalties;

    public Patient(){
    }
    
    public Patient(UserDTO userDTO) {
    	super(userDTO);
    }

    public Long getPenalties() {
        return penalties;
    }

    public void setPenalties(Long penalties) {
        this.penalties = penalties;
    }
}
