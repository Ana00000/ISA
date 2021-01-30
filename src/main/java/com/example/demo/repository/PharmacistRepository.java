package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Pharmacist;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Integer> {

}
