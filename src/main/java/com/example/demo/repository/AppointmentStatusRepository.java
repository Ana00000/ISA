package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AppointmentStatus;

public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Long> {
	
	AppointmentStatus findOneById(Long id);
	
	Page<AppointmentStatus> findAll(Pageable pageable);
}
