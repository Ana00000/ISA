package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Vacation;
import com.example.demo.repository.VacationRepository;
import com.example.demo.service.VacationService;

@Service
public class VacationServiceImpl implements VacationService {

    private VacationRepository vacationRepository;
    
	@Autowired
	public VacationServiceImpl(VacationRepository vacationRepository) {
		this.vacationRepository = vacationRepository;
	}
    
    public Vacation findOne(Long id) {
		return vacationRepository.findById(id).orElseGet(null);
	}
    
	public List<Vacation> findAll() {
		return vacationRepository.findAll();
	}
	
	public Page<Vacation> findAll(Pageable page) {
		return vacationRepository.findAll(page);
	}

	public Vacation save(Vacation vacation) {
		return vacationRepository.save(vacation);
	}

	public void remove(Long id) {
		vacationRepository.deleteById(id);
	}
}

