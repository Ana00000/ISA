package com.example.demo.service.impl;


import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import com.example.demo.repository.MedicineOrderRepository;
import com.example.demo.service.MedicineOrderService;
import org.apache.tomcat.jni.Time;
import org.postgresql.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<MedicineOrder> findAllByPharmacyId(Long pharmacyAdminId) { return medicineOrderRepository.findAllByPharmacyId(pharmacyAdminId); }

    @Override
    public List<HashMap<Medicine, Integer>> findMedicineAmountById(Long medicineOrderId) {
//        List<Tuple> list = medicineOrderRepository.findMedicineAmountById(medicineOrderId);
//        HashMap<Medicine, Integer> hashMap = new HashMap<>();
//        for (Tuple tuple : list) {
//            hashMap.put();
//        }
        return medicineOrderRepository.findMedicineAmountById(medicineOrderId);
    }

    @Override
    public List<MedicineOrder> findAll() {
        return medicineOrderRepository.findAll();
    }

    @Override
    public List<MedicineOrder> findAllActive() {
        List<MedicineOrder> medicineOrders = new ArrayList<>();
        long timeNow = System.currentTimeMillis();
        for(MedicineOrder mo :medicineOrderRepository.findAll()){
            if(mo.getDeadline().getTime()> timeNow){
                medicineOrders.add(mo);
            }
        }
        return medicineOrders;
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
