package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Dermatologist;

public interface DermatologistRepository extends JpaRepository<Dermatologist, Integer> {

}
