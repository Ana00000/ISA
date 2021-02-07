package com.example.demo.model;

import com.example.demo.dto.PromotionDTO;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="startTime", unique=false, nullable=true)
    private Timestamp startTime;

    @Column(name="endTime", unique=false, nullable=true)
    private Timestamp endTime;

    @Column(name="description", unique=false, nullable=true)
    private String description;

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
