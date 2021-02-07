package com.example.demo.service.impl;

import com.example.demo.model.Promotion;
import com.example.demo.repository.PromotionRepository;
import com.example.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion findOne(Long id) {
        return promotionRepository.getOne(id);
    }

    @Override
    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion save(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public void remove(Long id) {
        promotionRepository.deleteById(id);
    }
}
