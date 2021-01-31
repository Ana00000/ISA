package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.MedicineManufacturer;

public interface MedicineManufacturerService {
	
	MedicineManufacturer findOne(Long id);
    
	List<MedicineManufacturer> findAll();
	
	Page<MedicineManufacturer> findAll(Pageable page);

	List<MedicineManufacturer> findAllByName(String name);
	
	MedicineManufacturer save(MedicineManufacturer medicineManufacturer);

	void remove(Long id);
}