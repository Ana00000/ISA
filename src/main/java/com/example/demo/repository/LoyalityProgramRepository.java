package com.example.demo.repository;

import com.example.demo.model.LoyaltyProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyalityProgramRepository extends JpaRepository<LoyaltyProgram,Long> {
}
