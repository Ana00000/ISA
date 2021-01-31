package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.TypeOfMedicine;
import com.example.demo.repository.TypeOfMedicineRepository;
import com.example.demo.service.TypeOfMedicineService;

@Service
public class TypeOfMedicineServiceImpl implements TypeOfMedicineService {

    private TypeOfMedicineRepository typeOfMedicineRepository;
    
	@Autowired
	public TypeOfMedicineServiceImpl(TypeOfMedicineRepository typeOfMedicineRepository) {
		this.typeOfMedicineRepository = typeOfMedicineRepository;
	}
    
    public TypeOfMedicine findOne(Long id) {
		return typeOfMedicineRepository.findById(id).orElseGet(null);
	}
    
	public List<TypeOfMedicine> findAll() {
		return typeOfMedicineRepository.findAll();
	}
	
	public Page<TypeOfMedicine> findAll(Pageable page) {
		return typeOfMedicineRepository.findAll(page);
	}

	public TypeOfMedicine save(TypeOfMedicine typeOfMedicine) {
		return typeOfMedicineRepository.save(typeOfMedicine);
	}

	public void remove(Long id) {
		typeOfMedicineRepository.deleteById(id);
	}
}