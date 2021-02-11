package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.User;
import com.example.demo.service.impl.MedicineOrderServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MedicineOrderService {

    MedicineOrder findOne(Long id);

    List<MedicineOrder> findAll();

    Page<MedicineOrder> findAll(Pageable page);

    MedicineOrder save(MedicineOrder medicineOrder);

    void remove(Long id);
}
