package com.example.demo.dto;

import com.example.demo.model.Complaint;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class ComplaintAnswerDTO {
    private Long id;
    private Long complaintId;
    private String text;
    public  ComplaintAnswerDTO(){}
    public ComplaintAnswerDTO(Long id, Long complaintId, String text) {
        this.id = id;
        this.complaintId = complaintId;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
