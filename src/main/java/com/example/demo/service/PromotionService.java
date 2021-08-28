package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PromotionService {

    Promotion findOne(Long id);

    List<Promotion> findAllByPharmacyId(Long id);

    List<Promotion> findAll();

    Promotion save(Promotion promotion);

    void remove(Long id);
}
