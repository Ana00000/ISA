package com.example.demo.service.impl;


import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.User;
import com.example.demo.repository.MedicineOrderRepository;
import com.example.demo.service.MedicineOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineOrderServiceImpl implements MedicineOrderService {

    private final MedicineOrderRepository medicineOrderRepository;

    @Autowired
    public MedicineOrderServiceImpl(MedicineOrderRepository medicineOrderRepository) {
        this.medicineOrderRepository = medicineOrderRepository;
    }


    @Override
    public MedicineOrder findOne(Long id) {
        return medicineOrderRepository.findFirstById(id);
    }

    @Override
    public List<MedicineOrder> findAll() {
        return medicineOrderRepository.findAll();
    }

    @Override
    public Page<MedicineOrder> findAll(Pageable page) {
        return medicineOrderRepository.findAll(page);
    }

    @Override
    public MedicineOrder save(MedicineOrder medicineOrder) {
        return medicineOrderRepository.save(medicineOrder);
    }

    @Override
    public void remove(Long id) {
        medicineOrderRepository.deleteById(id);
    }
}
