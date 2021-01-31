package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.AppointmentType;

public interface AppointmentTypeService {

	AppointmentType findOne(Long id);
    
	List<AppointmentType> findAll();
	
	Page<AppointmentType> findAll(Pageable page);

	AppointmentType save(AppointmentType appointmentType);

	void remove(Long id);
}