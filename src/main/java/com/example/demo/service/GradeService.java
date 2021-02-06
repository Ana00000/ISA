package com.example.demo.service;

import com.example.demo.model.Grade;
import com.example.demo.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GradeService {

    Grade findOne(Long id);

    Grade findOneByUserIdAndPharmacyId(Long userId, Long pharmacyId);

    List<Grade> findAll();

    Page<Grade> findAll(Pageable page);

    Grade save(Grade grade);

    void remove(Long id);
}
