package com.example.demo.service;

import java.util.List;
import com.example.demo.model.PharmacyMedicine;

public interface PharmacyMedicineService {
	
	PharmacyMedicine findOne(Long id);

	List<PharmacyMedicine> findAll();
	
    PharmacyMedicine findByMedicineId(Long medicineId);

	PharmacyMedicine save(PharmacyMedicine pharmacyMedicine);
}
