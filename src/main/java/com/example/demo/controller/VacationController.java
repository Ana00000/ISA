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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VacationDTO;
import com.example.demo.model.Doctor;
import com.example.demo.model.Vacation;
import com.example.demo.service.DoctorService;
import com.example.demo.service.VacationService;
import com.example.demo.service.email.EmailServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/vacations", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacationController {
	
	private VacationService vacationService;
	private DoctorService doctorService;
    private final EmailServiceImpl emailService;
    
	@Autowired
	public VacationController(VacationService vacationService,
			DoctorService doctorService, EmailServiceImpl emailService) {
		this.vacationService = vacationService;
		this.doctorService = doctorService;
		this.emailService = emailService;
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
	
	@GetMapping(value = "/doctorVacation/{id}")
	public ResponseEntity<VacationDTO> getDoctorVacation(@PathVariable Long id) {

		Vacation vacation = null;
		for(Vacation v : vacationService.findAll())
			if(v.getDoctor().getId() == id)
				vacation = v;

		if (vacation == null) 
			return new ResponseEntity<>(null, HttpStatus.OK);
		
		return new ResponseEntity<>(new VacationDTO(vacation), HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveVacation")
    public ResponseEntity<VacationDTO> saveVacation(@RequestBody VacationDTO vacationDTO) {

        Vacation vacation = new Vacation();
		vacation.setStartTime(vacationDTO.getStartTime());
		vacation.setEndTime(vacationDTO.getEndTime());
		vacation.setStatus(vacationDTO.getStatus());
		
		Long doctorId = vacationDTO.getDoctor().getId();
		Doctor doctor = doctorService.findOne(doctorId);
		vacation.setDoctor(doctor);
		
		List<Vacation> vacations = vacationService.findAll();
		for(Vacation v: vacations) {
			if(v.getDoctor().getId().equals(doctorId)) {
				System.out.println("Doctor can not make another vacation request if"
						+ " there is already an existent one (from him)!");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		vacation = vacationService.save(vacation);
		
		emailService.sendEmail(vacation.getDoctor().getEmail(),
				"Greetings, your request was sent. Selected time interval is from "+vacation.getStartTime()+" to "+vacation.getEndTime()
				+". Regards, Hospital IsaIBisa", 
				"Vacation");
		
        return new ResponseEntity<>(new VacationDTO(vacation), HttpStatus.CREATED);
    }
}
