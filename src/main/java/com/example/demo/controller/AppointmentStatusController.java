package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AppointmentStatusDTO;
import com.example.demo.model.AppointmentStatus;
import com.example.demo.service.AppointmentStatusService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/appointmentStatuses", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentStatusController {
	
	private AppointmentStatusService appointmentStatusService;
    
	@Autowired
	public AppointmentStatusController(AppointmentStatusService appointmentStatusService) {
		this.appointmentStatusService = appointmentStatusService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AppointmentStatusDTO>> getAllAppointmentStatuses() {

		List<AppointmentStatus> appointmentStatuses = appointmentStatusService.findAll();

		List<AppointmentStatusDTO> appointmentStatusesDTO = new ArrayList<>();
		for (AppointmentStatus as : appointmentStatuses) {
			appointmentStatusesDTO.add(new AppointmentStatusDTO(as));
		}

		return new ResponseEntity<>(appointmentStatusesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AppointmentStatusDTO> getAppointmentStatus(@PathVariable Long id) {

		AppointmentStatus appointmentStatus = appointmentStatusService.findOne(id);

		if (appointmentStatus == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new AppointmentStatusDTO(appointmentStatus), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAppointmentStatus(@PathVariable Long id) {

		AppointmentStatus appointmentStatus = appointmentStatusService.findOne(id);

		if (appointmentStatus != null) {
			appointmentStatusService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}