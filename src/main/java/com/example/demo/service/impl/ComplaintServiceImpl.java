package com.example.demo.service.impl;

import com.example.demo.model.Complaint;
import com.example.demo.model.ComplaintAnswer;
import com.example.demo.repository.ComplaintAnswerRepository;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    ComplaintAnswerRepository complaintAnswerRepository;

    @Override
    public Complaint save(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getNotAnsweredCompalintments() {
        List<Complaint> complaints = new ArrayList<>();
        complaints.addAll(complaintRepository.findAll());
        for(Complaint complaint : complaintRepository.findAll()){
            for(ComplaintAnswer complaintAnswer : complaintAnswerRepository.findAll()){
                if(complaint.getId() == complaintAnswer.getComplaint().getId()){
                    complaints.remove(complaint);
                    break;
                }
            }
        }
        return complaints;
    }

    @Override
    public Complaint getById(Long id) {
        return complaintRepository.getOne(id);
    }
}
