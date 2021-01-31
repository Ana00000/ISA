package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Medicine;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository medicineRepository;
    
	@Autowired
	public MedicineServiceImpl(MedicineRepository medicineRepository) {
		this.medicineRepository = medicineRepository;
	}
    
    public Medicine findOne(Long id) {
		return medicineRepository.findById(id).orElseGet(null);
	}
    
	public List<Medicine> findAll() {
		return medicineRepository.findAll();
	}
	
	public Page<Medicine> findAll(Pageable page) {
		return medicineRepository.findAll(page);
	}
	
	public List<Medicine> findAllByName(String name) {
		return medicineRepository.findAllByName(name);
	}
	
	public List<Medicine> findAllByRecipeNeed(boolean recipeNeed) {
		return medicineRepository.findAllByRecipeNeed(recipeNeed);
	}
	
	public Medicine save(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	public void remove(Long id) {
		medicineRepository.deleteById(id);
	}
}