package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
	
	Page<Vacation> findAll(Pageable pageable);
}