package com.example.demo.service;

import com.example.demo.model.MedicineReservation;
import com.example.demo.model.PharmacyMedicinePK;
import com.example.demo.model.PharmacyMedicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MedicineReservationService {
    MedicineReservation findOne(Long id);

    List<MedicineReservation> findAll();

    Page<MedicineReservation> findAll(Pageable page);

    List<MedicineReservation> findAllByName(String name);

    MedicineReservation save(MedicineReservation medicineReservation);

    void remove(Long id);

    PharmacyMedicine findOnePharmacyMedicine(PharmacyMedicinePK key);

    PharmacyMedicine updatePharmacyMedicine(PharmacyMedicine pharmacyMedicine);
}
