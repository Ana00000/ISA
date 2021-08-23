package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "LoyaltyProgram")
public class LoyaltyProgram {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name="pointsForConsultation", unique=false, nullable=false)
    private int pointsForConsultation;

    @Column(name="pointsForExamination", unique=false, nullable=false)
    private int pointsForExamination;

    @Column(name="pointsForSilver", unique=false, nullable=false)
    private int pointsForSilver;

    @Column(name="pointsForGold", unique=false, nullable=false)
    private int pointsForGold;

    @Column(name="discauntForSilver", unique=false, nullable=false)
    private int discauntForSilver;

    @Column(name="discauntForGold", unique=false, nullable=false)
    private int discauntForGold;

    public LoyaltyProgram(){}

    public LoyaltyProgram(int discauntForGold){
        this.discauntForGold = discauntForGold;
    }

    public LoyaltyProgram(Long id, int pointsForConsultation, int pointsForExamination, int pointsForSilver, int pointsForGold, int discauntForGold) {
        this.id = id;
        this.pointsForConsultation = pointsForConsultation;
        this.pointsForExamination = pointsForExamination;
        this.pointsForSilver = pointsForSilver;
        this.pointsForGold = pointsForGold;
        this.discauntForGold = discauntForGold;
    }

    public int getDiscauntForSilver() {
        return discauntForSilver;
    }

    public void setDiscauntForSilver(int discauntForSilver) {
        this.discauntForSilver = discauntForSilver;
    }

    public int getDiscauntForGold() {
        return discauntForGold;
    }

    public void setDiscauntForGold(int discauntForGold) {
        this.discauntForGold = discauntForGold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPointsForConsultation() {
        return pointsForConsultation;
    }

    public void setPointsForConsultation(int pointsForConsultation) {
        this.pointsForConsultation = pointsForConsultation;
    }

    public int getPointsForExamination() {
        return pointsForExamination;
    }

    public void setPointsForExamination(int pointsForExamination) {
        this.pointsForExamination = pointsForExamination;
    }

    public int getPointsForSilver() {
        return pointsForSilver;
    }

    public void setPointsForSilver(int pointsForSilver) {
        this.pointsForSilver = pointsForSilver;
    }

    public int getPointsForGold() {
        return pointsForGold;
    }

    public void setPointsForGold(int pointsForGold) {
        this.pointsForGold = pointsForGold;
    }
}
