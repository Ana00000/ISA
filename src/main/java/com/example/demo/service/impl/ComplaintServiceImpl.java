package com.example.demo.service.impl;

import com.example.demo.model.Complaint;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    ComplaintRepository complaintRepository;

    @Override
    public Complaint save(Complaint complaint) {
        return complaintRepository.save(complaint);
    }
}
