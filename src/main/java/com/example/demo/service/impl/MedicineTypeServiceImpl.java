package com.example.demo.service.impl;

import com.example.demo.model.MedicineType;
import com.example.demo.repository.MedicineTypeRepository;
import com.example.demo.service.MedicineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineTypeServiceImpl implements MedicineTypeService {

    private MedicineTypeRepository medicineTypeRepository ;

    @Autowired
    public  MedicineTypeServiceImpl(MedicineTypeRepository medicineTypeRepository){
        this.medicineTypeRepository = medicineTypeRepository;
    }

    @Override
    public List<MedicineType> findAll() {
        return medicineTypeRepository.findAll();
    }

    @Override
    public List<MedicineType> findAllByType(String type) {
        return medicineTypeRepository.findAllByType(type);
    }

    @Override
    public MedicineType save(MedicineTypeRepository medicineType) {
        return medicineTypeRepository.save(medicineType);
    }
}
