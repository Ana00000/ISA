package com.example.demo.service;

import com.example.demo.model.Medicine;
import com.example.demo.model.PharmacyMedicine;

import java.util.List;

public interface PharmacyMedicineService {
	
	PharmacyMedicine findOne(Long id);

	List<PharmacyMedicine> findAll();
	
    PharmacyMedicine findByMedicineId(Long medicineId);

    List<Medicine> findMedicineByPharmacyId(Long id);

	PharmacyMedicine save(PharmacyMedicine pharmacyMedicine);
}
