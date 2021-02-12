package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dto.MedicineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyMedicine;
import com.example.demo.repository.PharmacyMedicineRepository;
import com.example.demo.service.PharmacyMedicineService;

@Service
public class PharmacyMedicineServiceImpl implements PharmacyMedicineService {

    private final PharmacyMedicineRepository pharmacyMedicineRepository;
    
    @Autowired
    public PharmacyMedicineServiceImpl(PharmacyMedicineRepository pharmacyMedicineRepository) {
        this.pharmacyMedicineRepository =  pharmacyMedicineRepository;
    }
    
	public List<PharmacyMedicine> findAll() {
		return pharmacyMedicineRepository.findAll();
	}
	
	public PharmacyMedicine findOne(Long id) {
		return pharmacyMedicineRepository.findById(id).orElseGet(null);
	}
	
	@Override
    public PharmacyMedicine findByMedicineId(Long medicineId) {
   	 	return pharmacyMedicineRepository.findByMedicineId(medicineId);
    }

	@Override
	public List<Medicine> findMedicineByPharmacyId(Long id) {
		return pharmacyMedicineRepository.findMedicineByPharmacyId(id);
	}

	@Override
	public PharmacyMedicine save(PharmacyMedicine pharmacyMedicine) {
		return pharmacyMedicineRepository.save(pharmacyMedicine);
	}

	@Override
	public PharmacyMedicine findByPharmacyIdAndMedicineId(Long pharmacyId, Long medicineId) {
		return pharmacyMedicineRepository.findByPharmacyIdAndMedicineId(pharmacyId, medicineId);
	}

	@Override
	public void updatePharmacyMedicine(PharmacyMedicine pharmacyMedicine) {
		pharmacyMedicineRepository.updatePharmacyMedicine(pharmacyMedicine);
	}
}