package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AppointmentType;
import com.example.demo.model.enums.AppointmentStatusValue;
import com.example.demo.model.enums.AppointmentTypeValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.AppointmentStatus;

public interface AppointmentStatusService {

	AppointmentStatus findOne(Long id);

	AppointmentStatus findByValue(AppointmentStatusValue value);
    
	List<AppointmentStatus> findAll();
	
	Page<AppointmentStatus> findAll(Pageable page);

	AppointmentStatus save(AppointmentStatus appointmentStatus);

	void remove(Long id);
}
