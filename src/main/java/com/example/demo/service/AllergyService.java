package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.Allergy;

public interface AllergyService {
	
	Allergy findOne(Long id);
    
	List<Allergy> findAll();
	
	Page<Allergy> findAll(Pageable page);

	Allergy save(Allergy allergy);

	void remove(Long id);
}
