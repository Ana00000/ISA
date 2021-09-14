package com.example.demo.service;

import com.example.demo.Exception.MyException;
import com.example.demo.dto.ComplaintAnswerDTO;
import com.example.demo.model.ComplaintAnswer;
import com.example.demo.model.Dermatologist;
import com.example.demo.model.Pharmacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ComplaintAnswerService {
    ComplaintAnswer findOne(Long id);

    List<ComplaintAnswer> findAll();

    ComplaintAnswer save(ComplaintAnswer complaintAnswer);

    void remove(Long id);

    ComplaintAnswerDTO save(ComplaintAnswerDTO complaintAnswerDTO) throws MyException;
}
