package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Authority;
import com.example.demo.model.Pharmacy;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dermatologist;
import com.example.demo.repository.DermatologistRepository;
import com.example.demo.service.DermatologistService;

@Service
public class DermatologistServiceImpl implements DermatologistService {

    private DermatologistRepository dermatologistRepository;
    private AuthorityService authorityService;
    
	@Autowired
	public DermatologistServiceImpl(DermatologistRepository dermatologistRepository, AuthorityService authorityService) {
		this.dermatologistRepository = dermatologistRepository;
		this.authorityService = authorityService;
	}
    
    public Dermatologist findOne(Long id) {
		return dermatologistRepository.findById(id).orElseGet(null);
	}
    
    public Dermatologist findOneByPassword(String password) {
		return dermatologistRepository.findOneByPassword(password);
	}

	public List<Dermatologist> findAll() {
		return dermatologistRepository.findAll();
	}
	
	public Page<Dermatologist> findAll(Pageable page) {
		return dermatologistRepository.findAll(page);
	}
	
	public List<Dermatologist> findAllByName(String name) {
		return dermatologistRepository.findAllByName(name);
	}
	
	public List<Dermatologist> findAllByLastName(String lastName) {
		return dermatologistRepository.findAllByLastName(lastName);
	}
	
	public List<Dermatologist> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
		return dermatologistRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
	}
	
	public List<Dermatologist> findAllByEmail(String email) {
		return dermatologistRepository.findAllByEmail(email);
	}

	@Override
	public List<Dermatologist> findAllByPharmacies(List<Pharmacy> pharmacies) {
		return dermatologistRepository.findAllByPharmaciesIsIn(pharmacies);
	}

	public Dermatologist save(Dermatologist dermatologist) {
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.findByName("ROLE_DERMATOLOGIST"));
		dermatologist.setAuthorities(authorities);
		return dermatologistRepository.save(dermatologist);
	}

	public void remove(Long id) {
		dermatologistRepository.deleteById(id);
	}
}

