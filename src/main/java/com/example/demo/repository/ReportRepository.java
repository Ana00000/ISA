package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
	
	Page<Report> findAll(Pageable pageable);
	
	List<Report> findAllByStartTime(Timestamp startTime);

	List<Report> findAllByEndTime(Timestamp endTime);

	List<Report> findAllByPatient(Patient patient);

	List<Report> findAllByDoctor(Doctor doctor);
}