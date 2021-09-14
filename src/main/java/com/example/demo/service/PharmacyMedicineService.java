package com.example.demo.service;

import com.example.demo.model.Medicine;
import com.example.demo.model.PharmacyMedicine;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PharmacyMedicineService {
	
	PharmacyMedicine findOne(Long id);

	List<PharmacyMedicine> findAll();

	List<PharmacyMedicine> findAllByPharmacyId(Long id);
	
    PharmacyMedicine findByMedicineId(Long medicineId);

	List<PharmacyMedicine> findAllByMedicineId(Long medicineId);

    List<Medicine> findMedicineByPharmacyId(Long id);

	PharmacyMedicine save(PharmacyMedicine pharmacyMedicine);

	PharmacyMedicine findByPharmacyIdAndMedicineId(Long pharmacyId, Long medicineId);

	void updatePharmacyMedicine(@Param("pharmacyMedicine") PharmacyMedicine pharmacyMedicine);
}
