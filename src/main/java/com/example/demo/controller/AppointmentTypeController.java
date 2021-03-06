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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AppointmentTypeDTO;
import com.example.demo.model.AppointmentType;
import com.example.demo.model.enums.AppointmentTypeValues;
import com.example.demo.service.AppointmentTypeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/appointmentTypes", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentTypeController {
	
	private AppointmentTypeService appointmentTypeService;
    
	@Autowired
	public AppointmentTypeController(AppointmentTypeService appointmentTypeService) {
		this.appointmentTypeService = appointmentTypeService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AppointmentTypeDTO>> getAllAppointmentTypes() {

		List<AppointmentType> appointmentTypes = appointmentTypeService.findAll();

		List<AppointmentTypeDTO> appointmentTypesDTO = new ArrayList<>();
		for (AppointmentType at : appointmentTypes) {
			appointmentTypesDTO.add(new AppointmentTypeDTO(at));
		}

		return new ResponseEntity<>(appointmentTypesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AppointmentTypeDTO> getAppointmentType(@PathVariable Long id) {

		AppointmentType appointmentType = appointmentTypeService.findOne(id);

		if (appointmentType == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new AppointmentTypeDTO(appointmentType), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAppointmentType(@PathVariable Long id) {

		AppointmentType appointmentType = appointmentTypeService.findOne(id);

		if (appointmentType != null) {
			appointmentTypeService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/saveExaminationAppointmentType")
    public ResponseEntity<AppointmentTypeDTO> saveExaminationAppointmentType(@RequestBody AppointmentTypeDTO appointmentTypeDTO) {

		AppointmentType appointmentType = new AppointmentType();
		appointmentType.setAppointmentTypeValue(AppointmentTypeValues.EXAMINATION);
		
		appointmentType = appointmentTypeService.save(appointmentType);
        return new ResponseEntity<>(new AppointmentTypeDTO(appointmentType), HttpStatus.CREATED);
    }
}