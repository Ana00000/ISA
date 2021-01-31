package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.AppointmentStatus;

public interface AppointmentStatusService {

	AppointmentStatus findOne(Long id);
    
	List<AppointmentStatus> findAll();
	
	Page<AppointmentStatus> findAll(Pageable page);

	AppointmentStatus save(AppointmentStatus appointmentStatus);

	void remove(Long id);
}
