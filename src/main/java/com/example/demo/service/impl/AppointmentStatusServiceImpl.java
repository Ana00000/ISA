package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.AppointmentStatus;
import com.example.demo.repository.AppointmentStatusRepository;
import com.example.demo.service.AppointmentStatusService;

@Service
public class AppointmentStatusServiceImpl implements AppointmentStatusService {

    private AppointmentStatusRepository appointmentStatusRepository;
    
	@Autowired
	public AppointmentStatusServiceImpl(AppointmentStatusRepository appointmentStatusRepository) {
		this.appointmentStatusRepository = appointmentStatusRepository;
	}
    
    public AppointmentStatus findOne(Long id) {
		return appointmentStatusRepository.findById(id).orElseGet(null);
	}
    
	public List<AppointmentStatus> findAll() {
		return appointmentStatusRepository.findAll();
	}
	
	public Page<AppointmentStatus> findAll(Pageable page) {
		return appointmentStatusRepository.findAll(page);
	}

	public AppointmentStatus save(AppointmentStatus appointmentStatus) {
		return appointmentStatusRepository.save(appointmentStatus);
	}

	public void remove(Long id) {
		appointmentStatusRepository.deleteById(id);
	}
}
