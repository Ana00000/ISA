package com.example.demo.repository;

import com.example.demo.model.enums.AppointmentStatusValue;
import com.example.demo.model.enums.AppointmentTypeValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AppointmentStatus;

public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Long> {
		
	Page<AppointmentStatus> findAll(Pageable pageable);

	AppointmentStatus findByStatusValue(AppointmentStatusValue statusValue);
}
