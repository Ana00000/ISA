package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.dto.UserDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient extends User implements Serializable{

    @Column(name = "subscribedToPromotions", unique = false, nullable = false)
    private Boolean subscribedToPromotions;

    @Column(name = "penalties", unique = false)
    private int penalties;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "patientsOnPromotion", joinColumns = @JoinColumn(name="promotion_id", referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
    private Set<Promotion> promotions = new HashSet<Promotion>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "allergiesOfPatient", joinColumns = @JoinColumn(name="allergy_id", referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
    private Set<Allergy> allergies = new HashSet<Allergy>();

    public Patient(){
    }
    
    public Patient(UserDTO userDTO) {
    	super(userDTO);
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public Boolean getSubscribedToPromotions() {
        return subscribedToPromotions;
    }

    public void setSubscribedToPromotions(Boolean subscribedToPromotions) {
        this.subscribedToPromotions = subscribedToPromotions;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Set<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(Set<Allergy> allergies) {
        this.allergies = allergies;
    }
}
