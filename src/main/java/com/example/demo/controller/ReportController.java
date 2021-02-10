package com.example.demo.controller;

import java.sql.Timestamp;
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
import com.example.demo.dto.ReportDTO;
import com.example.demo.model.Doctor;
import com.example.demo.model.Medicine;
import com.example.demo.model.Patient;
import com.example.demo.model.Report;
import com.example.demo.service.DoctorService;
import com.example.demo.service.MedicineService;
import com.example.demo.service.PatientService;
import com.example.demo.service.ReportService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/reports", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
	
	private ReportService reportService;
	private MedicineService medicineService;
	private DoctorService doctorService;
	private PatientService patientService;
    
	@Autowired
	public ReportController(ReportService reportService,MedicineService medicineService,
			DoctorService doctorService, PatientService patientService) {
		this.reportService = reportService;
		this.medicineService = medicineService;
		this.doctorService = doctorService;
		this.patientService = patientService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ReportDTO>> getAllReports() {

		List<Report> reports = reportService.findAll();

		List<ReportDTO> reportsDTO = new ArrayList<>();
		for (Report r : reports) {
			reportsDTO.add(new ReportDTO(r));
		}

		return new ResponseEntity<>(reportsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReportDTO> getReport(@PathVariable Long id) {

		Report report = reportService.findOne(id);

		if (report == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ReportDTO(report), HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveReport")
    public ResponseEntity<ReportDTO> saveReport(@RequestBody ReportDTO reportDTO) {

		Report report = new Report();

		setOfValidTherapyDays(reportDTO, report);
		setOfValidInterval(reportDTO, report);
		
		if(reportDTO.getMedicine() != null) {
			Long medicineId = reportDTO.getMedicine().getId();
			Medicine medicine = medicineService.findOne(medicineId);
			report.setMedicine(medicine);
		}else {
			report.setMedicine(null);
		}
		
		if(reportDTO.getDoctor() != null) {
			Long doctorId = reportDTO.getDoctor().getId();
			Doctor doctor = doctorService.findOne(doctorId);
			report.setDoctor(doctor);
		}else {
			report.setDoctor(null);
		}
		
		if(reportDTO.getPatient() != null) {
			Long patientId = reportDTO.getPatient().getId();
			Patient patient = patientService.findOne(patientId);
			report.setPatient(patient);
		}else {
			report.setPatient(null);
		}
		
		report = reportService.save(report);
        return new ResponseEntity<>(new ReportDTO(report), HttpStatus.CREATED);
    }

	private void setOfValidTherapyDays(ReportDTO reportDTO, Report report) {
		if(reportDTO.getTherapyInDays() < 0) {
			 System.out.println("Therapy days can't be negative!");
			 return;
	    }else 
	    	report.setTherapyInDays(reportDTO.getTherapyInDays());
	}
	
	private void setOfValidInterval(ReportDTO reportDTO, Report report) {
		Timestamp start = reportDTO.getStartTime();
		Timestamp end = reportDTO.getEndTime();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		if(end == null) {
			 System.out.println("End time needs a value!");
			 return;
	    }else if(start == null) {
	    	 System.out.println("Start time needs a value!");
	    	 return;
	    }else if (end.before(start)) {
	    	 System.out.println("Start time comes before end time!");
	    	 return;
	    }else if(start.before(currentTime)) {
	    	 System.out.println("Start time has passed!");
	    	 return;
	    }else if(end.before(currentTime)) {
	    	 System.out.println("End time has passed!");
	    	 return;
	    }else {
	    	report.setStartTime(reportDTO.getStartTime());
	    	report.setEndTime(reportDTO.getEndTime());
	    }
	}
}