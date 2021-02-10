package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.model.enums.AppointmentTypeValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.AppointmentType;
import com.example.demo.repository.AppointmentTypeRepository;
import com.example.demo.service.AppointmentTypeService;

@Service
public class AppointmentTypeServiceImpl implements AppointmentTypeService {

    private AppointmentTypeRepository appointmentTypeRepository;
    
	@Autowired
	public AppointmentTypeServiceImpl(AppointmentTypeRepository appointmentTypeRepository) {
		this.appointmentTypeRepository = appointmentTypeRepository;
	}
    
    public AppointmentType findOne(Long id) {
		return appointmentTypeRepository.findById(id).orElseGet(null);
	}
    
	public List<AppointmentType> findAll() {
		return appointmentTypeRepository.findAll();
	}
	
	public Page<AppointmentType> findAll(Pageable page) {
		return appointmentTypeRepository.findAll(page);
	}

	public AppointmentType save(AppointmentType appointmentType) {
		return appointmentTypeRepository.save(appointmentType);
	}

	public void remove(Long id) {
		appointmentTypeRepository.deleteById(id);
	}

	@Override
	public AppointmentType findByTypeValue(AppointmentTypeValues value) {
		return appointmentTypeRepository.findByAppointmentTypeValue(value);
	}
}
