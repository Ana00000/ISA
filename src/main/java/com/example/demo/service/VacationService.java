package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.Vacation;

public interface VacationService {
	
	Vacation findOne(Long id);
    
	List<Vacation> findAll();
	
	Page<Vacation> findAll(Pageable page);

	Vacation save(Vacation allergy);

	void remove(Long id);
}
