package com.example.demo.model;

import javax.persistence.*;

@Entity
public class MedicineType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicineType(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
