package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyMedicine;
import com.example.demo.repository.PharmacyMedicineRepository;
import com.example.demo.service.PharmacyMedicineService;

@Service
public class PharmacyMedicineServiceImpl implements PharmacyMedicineService {

    private PharmacyMedicineRepository pharmacyMedicineRepository;
    
    @Autowired
    public PharmacyMedicineServiceImpl(PharmacyMedicineRepository pharmacyMedicineRepository) {
        this.pharmacyMedicineRepository =  pharmacyMedicineRepository;
    }
    
	@Override
	public List<PharmacyMedicine> findAll() {
		return pharmacyMedicineRepository.findAll();
	}
	
	public PharmacyMedicine findOne(Long id) {
		return pharmacyMedicineRepository.findById(id).orElseGet(null);
	}
	
	@Override
	public PharmacyMedicine findByMedicineAndPharmacy(Medicine medicine, Pharmacy pharmacy) {
		return pharmacyMedicineRepository.findByMedicineAndPharmacy(medicine, pharmacy);
	}
	
	@Override
    public PharmacyMedicine findByMedicineId(Long medicineId) {
   	 	return pharmacyMedicineRepository.findByMedicineId(medicineId);
    }
}