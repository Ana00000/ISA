package com.example.demo.repository;

import com.example.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    Grade findOneByUserIdAndPharmacyId(Long userId, Long pharmacyId);
}
