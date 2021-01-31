package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.MedicineIngredient;
import com.example.demo.repository.MedicineIngredientRepository;
import com.example.demo.service.MedicineIngredientService;

@Service
public class MedicineIngredientServiceImpl implements MedicineIngredientService {

    private MedicineIngredientRepository medicineIngredientRepository;
    
	@Autowired
	public MedicineIngredientServiceImpl(MedicineIngredientRepository medicineIngredientRepository) {
		this.medicineIngredientRepository = medicineIngredientRepository;
	}
    
    public MedicineIngredient findOne(Long id) {
		return medicineIngredientRepository.findById(id).orElseGet(null);
	}
    
	public List<MedicineIngredient> findAll() {
		return medicineIngredientRepository.findAll();
	}
	
	public Page<MedicineIngredient> findAll(Pageable page) {
		return medicineIngredientRepository.findAll(page);
	}
	
	public List<MedicineIngredient> findAllByName(String name) {
		return medicineIngredientRepository.findAllByName(name);
	}
	
	public MedicineIngredient save(MedicineIngredient medicineIngredient) {
		return medicineIngredientRepository.save(medicineIngredient);
	}

	public void remove(Long id) {
		medicineIngredientRepository.deleteById(id);
	}
}