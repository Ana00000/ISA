package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.MedicineShape;

public interface MedicineShapeService {
	
	MedicineShape findOne(Long id);
    
	List<MedicineShape> findAll();
	
	Page<MedicineShape> findAll(Pageable page);

	MedicineShape save(MedicineShape medicineShape);

	void remove(Long id);
}