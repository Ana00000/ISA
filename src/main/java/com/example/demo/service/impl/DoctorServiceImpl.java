package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    
	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
    
    public Doctor findOne(Long id) {
		return doctorRepository.findById(id).orElseGet(null);
	}
    
    public Doctor findOneByPassword(String password) {
		return doctorRepository.findOneByPassword(password);
	}

	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	public Page<Doctor> findAll(Pageable page) {
		return doctorRepository.findAll(page);
	}
	
	public List<Doctor> findAllByType(String type) {
		return doctorRepository.findAllByType(type);
	}
	
	public List<Doctor> findAllByName(String name) {
		return doctorRepository.findAllByName(name);
	}
	
	public List<Doctor> findAllByLastName(String lastName) {
		return doctorRepository.findAllByLastName(lastName);
	}
	
	public List<Doctor> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
		return doctorRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
	}
	
	public List<Doctor> findAllByEmail(String email) {
		return doctorRepository.findAllByEmail(email);
	}

	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public void remove(Long id) {
		doctorRepository.deleteById(id);
	}
}