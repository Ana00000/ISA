package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Report;

public interface ReportService {
	
	Report findOne(Long id);

	List<Report> findAll();
	
	Page<Report> findAll(Pageable page);
	
	List<Report> findAllByStartTime(Timestamp startTime);

	List<Report> findAllByEndTime(Timestamp endTime);

	List<Report> findAllByPatient(Patient patient);

	List<Report> findAllByDoctor(Doctor doctor);

	Report save(Report report);

	void remove(Long id);
}
