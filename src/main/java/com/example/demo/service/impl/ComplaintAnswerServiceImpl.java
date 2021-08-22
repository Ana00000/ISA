package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintAnswerDTO;
import com.example.demo.model.Complaint;
import com.example.demo.model.ComplaintAnswer;
import com.example.demo.repository.ComplaintAnswerRepository;
import com.example.demo.service.ComplaintAnswerService;
import com.example.demo.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComplaintAnswerServiceImpl implements ComplaintAnswerService {

    @Autowired
    private ComplaintAnswerRepository complaintAnswerRepository;

    @Autowired
    private ComplaintService complaintService;

    @Override
    public ComplaintAnswer findOne(Long id) {
        return complaintAnswerRepository.findById(id).get();
    }

    @Override
    public List<ComplaintAnswer> findAll() {
        return complaintAnswerRepository.findAll();
    }

    @Override
    public ComplaintAnswer save(ComplaintAnswer complaintAnswer) {
        return complaintAnswerRepository.save(complaintAnswer);
    }

    @Override
    public void remove(Long id) {
        complaintAnswerRepository.deleteById(id);
    }

    @Override
    public ComplaintAnswerDTO save(ComplaintAnswerDTO complaintAnswerDTO) {
        ComplaintAnswer complaintAnswer = new ComplaintAnswer(complaintAnswerDTO);
        complaintAnswer.setComplaint(complaintService.getById(complaintAnswerDTO.getComplaintId()));
        complaintAnswerRepository.save(complaintAnswer);
        return complaintAnswerDTO;
    }
}
