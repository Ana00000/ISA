package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.VacationDTO;
import com.example.demo.model.Vacation;
import com.example.demo.service.VacationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/vacations", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacationController {
	
	private VacationService vacationService;
    
	@Autowired
	public VacationController(VacationService vacationService) {
		this.vacationService = vacationService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<VacationDTO>> getAllVacations() {

		List<Vacation> vacations = vacationService.findAll();
		List<VacationDTO> vacationsDTO = new ArrayList<>();
		
		for (Vacation v : vacations) 
			vacationsDTO.add(new VacationDTO(v));

		return new ResponseEntity<>(vacationsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VacationDTO> getVacation(@PathVariable Long id) {

		Vacation vacation = vacationService.findOne(id);

		if (vacation == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(new VacationDTO(vacation), HttpStatus.OK);
	}
	
	@GetMapping(value = "doctorVacation/{id}")
	public ResponseEntity<VacationDTO> getDoctorVacation(@PathVariable Long id) {

		Vacation vacation = null;
		for(Vacation v : vacationService.findAll())
			if(v.getDoctor().getId() == id)
				vacation = v;

		if (vacation == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(new VacationDTO(vacation), HttpStatus.OK);
	}
}
