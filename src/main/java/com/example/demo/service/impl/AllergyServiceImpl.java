package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Allergy;
import com.example.demo.repository.AllergyRepository;
import com.example.demo.service.AllergyService;

@Service
public class AllergyServiceImpl implements AllergyService {

    private AllergyRepository allergyRepository;
    
	@Autowired
	public AllergyServiceImpl(AllergyRepository allergyRepository) {
		this.allergyRepository = allergyRepository;
	}
    
    public Allergy findOne(Long id) {
		return allergyRepository.findById(id).orElseGet(null);
	}
    
	public List<Allergy> findAll() {
		return allergyRepository.findAll();
	}
	
	public Page<Allergy> findAll(Pageable page) {
		return allergyRepository.findAll(page);
	}

	public Allergy save(Allergy allergy) {
		return allergyRepository.save(allergy);
	}

	public void remove(Long id) {
		allergyRepository.deleteById(id);
	}
}
