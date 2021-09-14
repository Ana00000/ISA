package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.User;
import com.example.demo.service.impl.MedicineOrderServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MedicineOrderService {

    MedicineOrder findOne(Long id);

    List<MedicineOrder> findAllByPharmacyId(Long orderId);

    List<HashMap<Medicine, Integer>> findMedicineAmountById(@Param("medicineOrderId") Long medicineOrderId);

    List<MedicineOrder> findAll();

    List<MedicineOrder> findAllActive();

    Page<MedicineOrder> findAll(Pageable page);

    MedicineOrder save(MedicineOrder medicineOrder);

    void remove(Long id);
}
