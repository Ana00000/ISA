package com.example.demo.model;

import com.example.demo.dto.ComplaintAnswerDTO;

import javax.persistence.*;

@Entity
public class ComplaintAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Complaint complaint;

    @Column(name="text", unique=false, nullable=false)
    private String text;

    @Version
    private Long version;

    public ComplaintAnswer(){}

    public ComplaintAnswer(Long id, Complaint complaint, String text) {
        this.id = id;
        this.complaint = complaint;
        this.text = text;
    }

    public ComplaintAnswer(ComplaintAnswerDTO complaintAnswerDTO){
        this.id = complaintAnswerDTO.getId();
        this.text = complaintAnswerDTO.getText();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
