package com.example.demo.service;

import com.example.demo.model.MedicineOffer;
import com.example.demo.model.MedicineOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicineOfferService {

    MedicineOffer findOne(Long id);

    List<MedicineOffer> findAllByOrderId(Long pharmacyAdminId);

    List<MedicineOffer> findAll();

    Page<MedicineOffer> findAll(Pageable page);

    MedicineOffer save(MedicineOffer medicineOrder);

    void remove(Long id);
}
