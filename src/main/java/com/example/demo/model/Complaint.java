package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pharmacy pharmacy;
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @Column( nullable = true )
    private String answer;

    @Column(nullable = true)
    private String UserNameFromUserWhoAnswered;

    public Complaint() {
    }

    public String getUserNameFromUserWhoAnswered() {
        return UserNameFromUserWhoAnswered;
    }

    public void setUserNameFromUserWhoAnswered(String userNameFromUserWhoAnswered) {
        UserNameFromUserWhoAnswered = userNameFromUserWhoAnswered;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
