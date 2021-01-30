package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Allergy;

public interface AllergyRepository extends JpaRepository<Allergy, Integer> {

}
