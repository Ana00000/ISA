package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ElementCollection
    @CollectionTable(name = "medicine_recipe_mapping", joinColumns = @JoinColumn(name = "recipe_id"))
    @MapKeyJoinColumn(name = "medicine_id", referencedColumnName = "id")
    @Column(name = "medicine_recipe_amount")
    private Map<Medicine, Integer> medicineAmount = new HashMap<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;

    @Column(nullable = false)
    private Timestamp dateOfIssue;

    public Recipe(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Medicine, Integer> getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(Map<Medicine, Integer> medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    public Timestamp getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Timestamp dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Timestamp getTime() {
        return dateOfIssue;
    }

    public void setTime(Timestamp time) {
        this.dateOfIssue = time;
    }
}
