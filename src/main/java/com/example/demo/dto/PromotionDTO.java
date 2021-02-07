package com.example.demo.dto;

import com.example.demo.model.Promotion;

import java.sql.Timestamp;
import java.util.Date;

public class PromotionDTO {

    private Long id;

    private Timestamp start;

    private Timestamp end;

    private String description;

    public PromotionDTO() {
    }

    public PromotionDTO(Long id, Timestamp start, Timestamp end, String description) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public PromotionDTO(Promotion promotion) {
        this.id = promotion.getId();
        this.start = promotion.getStart();
        this.end = promotion.getEnd();
        this.description = promotion.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PromotionDTO{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }
}
