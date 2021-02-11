package com.example.demo.model;

import com.example.demo.dto.PromotionDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Promotion implements Serializable {

    @Id
    @SequenceGenerator(name = "promotionIdSeqGen", sequenceName = "promotionIdSeqGen", initialValue = 5, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promotionIdSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="startTime", unique=false, nullable=true)
    private Timestamp startTime;

    @Column(name="endTime", unique=false, nullable=true)
    private Timestamp endTime;

    @Column(name="description", unique=false, nullable=true)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

    public Promotion() {
    }

    public Promotion(Long id, Timestamp startTime, Timestamp endTime, String description) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public Promotion(Timestamp startTime, Timestamp endTime, String description) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public Promotion(PromotionDTO promotionDTO) {
        this.id = promotionDTO.getId();
        this.startTime = promotionDTO.getStart();
        this.endTime = promotionDTO.getEnd();
        this.description = promotionDTO.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStart() {
        return startTime;
    }

    public void setStart(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEnd() {
        return endTime;
    }

    public void setEnd(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", start=" + startTime +
                ", end=" + endTime +
                ", description='" + description + '\'' +
                '}';
    }
}
