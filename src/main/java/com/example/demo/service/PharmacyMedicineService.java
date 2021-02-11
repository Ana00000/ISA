package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyMedicine;

public interface PharmacyMedicineService {
	
    List<PharmacyMedicine> findAll();
    
	PharmacyMedicine findOne(Long id);
	
    PharmacyMedicine findByMedicineAndPharmacy(Medicine medicine, Pharmacy pharmacy);

    PharmacyMedicine findByMedicineId(Long medicineId);
}
