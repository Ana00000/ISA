package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.MedicineShape;
import com.example.demo.repository.MedicineShapeRepository;
import com.example.demo.service.MedicineShapeService;

@Service
public class MedicineShapeServiceImpl implements MedicineShapeService {

    private MedicineShapeRepository medicineShapeRepository;
    
	@Autowired
	public MedicineShapeServiceImpl(MedicineShapeRepository medicineShapeRepository) {
		this.medicineShapeRepository = medicineShapeRepository;
	}
    
    public MedicineShape findOne(Long id) {
		return medicineShapeRepository.findById(id).orElseGet(null);
	}
    
	public List<MedicineShape> findAll() {
		return medicineShapeRepository.findAll();
	}
	
	public Page<MedicineShape> findAll(Pageable page) {
		return medicineShapeRepository.findAll(page);
	}

	public MedicineShape save(MedicineShape medicineShape) {
		return medicineShapeRepository.save(medicineShape);
	}

	public void remove(Long id) {
		medicineShapeRepository.deleteById(id);
	}
}