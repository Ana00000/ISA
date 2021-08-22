package com.example.demo.service.impl;

import com.example.demo.model.LoyaltyProgram;
import com.example.demo.model.User;
import com.example.demo.repository.LoyalityProgramRepository;
import com.example.demo.service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoyaltyProgramServiceImpl implements LoyaltyProgramService {

    @Autowired
    private LoyalityProgramRepository loyalityProgramRepository;

    @Override
    public LoyaltyProgram findOne(Long id) {
        return loyalityProgramRepository.findById(id).get();
    }

    @Override
    public List<LoyaltyProgram> findAll() {
        return loyalityProgramRepository.findAll();
    }

    @Override
    public LoyaltyProgram save(LoyaltyProgram loyaltyProgram) {
        return loyalityProgramRepository.save(loyaltyProgram);
    }

    @Override
    public void remove(Long id) {
        loyalityProgramRepository.deleteById(id);
    }
}
