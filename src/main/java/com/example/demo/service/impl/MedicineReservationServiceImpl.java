package com.example.demo.service.impl;

import com.example.demo.model.MedicineReservation;
import com.example.demo.model.PharmacyMedicinePK;
import com.example.demo.model.PharmacyMedicine;
import com.example.demo.repository.MedicineReservationRepository;
import com.example.demo.repository.PharmacyMedicineRepository;
import com.example.demo.service.MedicineReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineReservationServiceImpl implements MedicineReservationService {
    @Autowired
    private MedicineReservationRepository medicineReservationRepository;

    @Autowired
    private PharmacyMedicineRepository pharmacyMedicineRepository;

    @Override
    public MedicineReservation findOne(Long id) {
        return null;
    }

    @Override
    public List<MedicineReservation> findAll() {
        return null;
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
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<PharmacyMedicine> findOnePharmacyMedicine(PharmacyMedicinePK medicineReservationPK) {
        //return pharmacyMedicineRepository.findOne(pharmacyMedicine);
        return pharmacyMedicineRepository.findById(medicineReservationPK);
    }
}
