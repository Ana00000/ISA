package com.example.demo.repository;

import com.example.demo.model.ComplaintAnswer;
import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintAnswerRepository extends JpaRepository<ComplaintAnswer,Long> {
    ComplaintAnswer findOneByComplaintId(Long id);
}

