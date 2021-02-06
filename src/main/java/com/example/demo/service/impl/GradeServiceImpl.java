package com.example.demo.service.impl;

import com.example.demo.model.Grade;
import com.example.demo.repository.GradeRepository;
import com.example.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade findOne(Long id) {
        return gradeRepository.findById(id).orElseGet(null);
    }

    @Override
    public Grade findOneByUserIdAndPharmacyId(Long userId, Long pharmacyId) {
        return gradeRepository.findOneByUserIdAndPharmacyId(userId, pharmacyId);
    }

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Page<Grade> findAll(Pageable page) {
        return gradeRepository.findAll(page);
    }

    @Override
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public void remove(Long id) {
        gradeRepository.deleteById(id);
    }
}
