package com.example.demo.service;

import com.example.demo.model.Complaint;

import java.util.List;

public interface ComplaintService {
    Complaint save(Complaint complaint);

    List<Complaint> getNotAnsweredCompalintments();

    Complaint getById(Long id);
}
