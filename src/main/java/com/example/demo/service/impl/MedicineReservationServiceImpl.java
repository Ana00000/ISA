package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.model.enums.MedicineReservationStatusValue;
import com.example.demo.repository.MedicineReservationRepository;
import com.example.demo.repository.PharmacyMedicineRepository;
import com.example.demo.service.MedicineReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineReservationServiceImpl implements MedicineReservationService {
    @Autowired
    private MedicineReservationRepository medicineReservationRepository;

    @Autowired
    private PharmacyMedicineRepository pharmacyMedicineRepository;

    @Override
    public MedicineReservation findOne(Long id) {
        return medicineReservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<MedicineReservation> findAll() {
        return medicineReservationRepository.findAll();
    }

    @Override
    public Page<MedicineReservation> findAll(Pageable page) {
        return null;
    }

    @Override
    public List<MedicineReservation> findAllByName(String name) {
        return null;
    }

    @Override
    public MedicineReservation save(MedicineReservation medicineReservation) {
        return medicineReservationRepository.save(medicineReservation);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public PharmacyMedicine findOnePharmacyMedicine(Long key) {
        return pharmacyMedicineRepository.findById(key).orElse(null);
    }

    @Override
    public PharmacyMedicine findByMedicineAndPharmacy(Medicine medicine, Pharmacy pharmacy) {
        return pharmacyMedicineRepository.findByMedicineAndPharmacy(medicine, pharmacy);
    }

    @Override
    public PharmacyMedicine updatePharmacyMedicine(PharmacyMedicine pharmacyMedicine){
        return pharmacyMedicineRepository.save(pharmacyMedicine);
    }
}
