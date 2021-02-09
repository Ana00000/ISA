package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Report;
import com.example.demo.repository.ReportRepository;
import com.example.demo.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    
	@Autowired
	public ReportServiceImpl(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}
    
    public Report findOne(Long id) {
		return reportRepository.findById(id).orElseGet(null);
	}

	public List<Report> findAll() {
		return reportRepository.findAll();
	}
	
	public Page<Report> findAll(Pageable page) {
		return reportRepository.findAll(page);
	}
	
	public List<Report> findAllByStartTime(Timestamp startTime) {
		return reportRepository.findAllByStartTime(startTime);
	}

	public List<Report> findAllByEndTime(Timestamp endTime) {
		return reportRepository.findAllByEndTime(endTime);
	}

	public List<Report> findAllByPatient(Patient patient) {
		return reportRepository.findAllByPatient(patient);
	}

	public List<Report> findAllByDoctor(Doctor doctor) {
		return reportRepository.findAllByDoctor(doctor); 
	}

	public Report save(Report report) {
		return reportRepository.save(report);
	}

	public void remove(Long id) {
		reportRepository.deleteById(id);
	}
}
