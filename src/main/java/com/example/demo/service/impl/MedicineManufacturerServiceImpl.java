package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.MedicineManufacturer;
import com.example.demo.repository.MedicineManufacturerRepository;
import com.example.demo.service.MedicineManufacturerService;

@Service
public class MedicineManufacturerServiceImpl implements MedicineManufacturerService {

    private  MedicineManufacturerRepository medicineManufacturerRepository;
    
	@Autowired
	public MedicineManufacturerServiceImpl(MedicineManufacturerRepository medicineManufacturerRepository) {
		this.medicineManufacturerRepository = medicineManufacturerRepository;
	}
    
    public MedicineManufacturer findOne(Long id) {
		return medicineManufacturerRepository.findById(id).orElseGet(null);
	}
    
	public List<MedicineManufacturer> findAll() {
		return medicineManufacturerRepository.findAll();
	}
	
	public Page<MedicineManufacturer> findAll(Pageable page) {
		return medicineManufacturerRepository.findAll(page);
	}
	
	public List<MedicineManufacturer> findAllByName(String name) {
		return medicineManufacturerRepository.findAllByName(name);
	}
	
	public MedicineManufacturer save(MedicineManufacturer medicineManufacturer) {
		return medicineManufacturerRepository.save(medicineManufacturer);
	}

	public void remove(Long id) {
		medicineManufacturerRepository.deleteById(id);
	}
}