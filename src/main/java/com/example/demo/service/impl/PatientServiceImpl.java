package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    
	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
    
    public Patient findOne(Long id) {
		return patientRepository.findById(id).orElseGet(null);
	}
    
    public Patient findOneByPassword(String password) {
		return patientRepository.findOneByPassword(password);
	}

	public List<Patient> findAll() {
		return patientRepository.findAll();
	}
	
	public Page<Patient> findAll(Pageable page) {
		return patientRepository.findAll(page);
	}
	
	public List<Patient> findAllByName(String name) {
		return patientRepository.findAllByName(name);
	}
	
	public List<Patient> findAllByLastName(String lastName) {
		return patientRepository.findAllByLastName(lastName);
	}
	
	public List<Patient> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
		return patientRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
	}
	
	public List<Patient> findAllByEmail(String email) {
		return patientRepository.findAllByEmail(email);
	}

	@Override
	public Patient findOneByEmail(String email) {
		return patientRepository.findOneByEmail(email);
	}

	@Override
	public List<Patient> findAllBySubscribedToPromotions(Boolean subscribedToPromotions) {
		return patientRepository.findAllBySubscribedToPromotions(subscribedToPromotions);
	}

	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

	public void remove(Long id) {
		patientRepository.deleteById(id);
	}
}