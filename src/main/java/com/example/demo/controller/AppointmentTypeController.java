package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.AppointmentTypeService;

@RestController
@RequestMapping(value = "/appointmentTypes", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentTypeController {
	
	private AppointmentTypeService appointmentTypeService;
    
	@Autowired
	public AppointmentTypeController(AppointmentTypeService appointmentTypeService) {
		this.appointmentTypeService = appointmentTypeService;
	}
}