package com.example.demo.service.impl;

import com.example.demo.model.MedicineOffer;
import com.example.demo.repository.MedicineOfferRepository;
import com.example.demo.service.MedicineOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineOfferServiceImpl implements MedicineOfferService {

    private final MedicineOfferRepository medicineOfferRepository;

    @Autowired
    public MedicineOfferServiceImpl(MedicineOfferRepository medicineOfferRepository) {
        this.medicineOfferRepository = medicineOfferRepository;
    }

    @Override
    public MedicineOffer findOne(Long id) {
        return medicineOfferRepository.getOne(id);
    }

    @Override
    public List<MedicineOffer> findAllByOrderId(Long orderId) {
        return medicineOfferRepository.findAllByMedicineOrderId(orderId);
    }

    @Override
    public List<MedicineOffer> findAll() {
        return medicineOfferRepository.findAll();
    }

    @Override
    public Page<MedicineOffer> findAll(Pageable page) {
        return medicineOfferRepository.findAll(page);
    }

    @Override
    public MedicineOffer save(MedicineOffer medicineOrder) {
        return medicineOfferRepository.save(medicineOrder);
    }

    @Override
    public void remove(Long id) {
        medicineOfferRepository.deleteById(id);
    }
}
