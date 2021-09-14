package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Authority;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Pharmacist;
import com.example.demo.repository.PharmacistRepository;
import com.example.demo.service.PharmacistService;

@Service
public class PharmacistServiceImpl implements PharmacistService {

    private PharmacistRepository pharmacistRepository;
	private AuthorityService authorityService;
    
	@Autowired
	public PharmacistServiceImpl(PharmacistRepository pharmacistRepository, AuthorityService authorityService) {
		this.pharmacistRepository = pharmacistRepository;
		this.authorityService = authorityService;
	}
    
    public Pharmacist findOne(Long id) {
		return pharmacistRepository.findById(id).orElseGet(null);
	}
    
    public Pharmacist findOneByPassword(String password) {
		return pharmacistRepository.findOneByPassword(password);
	}

	public List<Pharmacist> findAll() {
		return pharmacistRepository.findAll();
	}
	
	public Page<Pharmacist> findAll(Pageable page) {
		return pharmacistRepository.findAll(page);
	}
	
	public List<Pharmacist> findAllByName(String name) {
		return pharmacistRepository.findAllByName(name);
	}
	
	public List<Pharmacist> findAllByLastName(String lastName) {
		return pharmacistRepository.findAllByLastName(lastName);
	}
	
	public List<Pharmacist> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
		return pharmacistRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
	}
	
	public List<Pharmacist> findAllByEmail(String email) {
		return pharmacistRepository.findAllByEmail(email);
	}

	public Pharmacist save(Pharmacist pharmacist) {
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.findByName("ROLE_PHARMACIST"));
		pharmacist.setAuthorities(authorities);
		return pharmacistRepository.save(pharmacist);
	}

	public void remove(Long id) {
		pharmacistRepository.deleteById(id);
	}
}