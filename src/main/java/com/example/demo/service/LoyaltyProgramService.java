package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.LoyaltyProgram;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoyaltyProgramService {
    LoyaltyProgram findOne(Long id);

    List<LoyaltyProgram> findAll();

    LoyaltyProgram save(LoyaltyProgram loyaltyProgram);

    void remove(Long id);
}
