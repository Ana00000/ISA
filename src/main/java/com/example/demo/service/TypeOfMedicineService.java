package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.TypeOfMedicine;

public interface TypeOfMedicineService {
	
	TypeOfMedicine findOne(Long id);
    
	List<TypeOfMedicine> findAll();
	
	Page<TypeOfMedicine> findAll(Pageable page);

	TypeOfMedicine save(TypeOfMedicine typeOfMedicine);

	void remove(Long id);
}