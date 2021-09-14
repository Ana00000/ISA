package com.example.demo.repository;

import com.example.demo.model.Promotion;
import com.example.demo.service.PromotionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findAllByPharmacyId(Long id);
}
