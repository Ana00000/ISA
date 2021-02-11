package com.example.demo.service;

import com.example.demo.model.*;
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

    PharmacyMedicine findOnePharmacyMedicine(Long key);

    PharmacyMedicine findByMedicineAndPharmacy(Medicine medicine, Pharmacy Pharmacy);

    PharmacyMedicine updatePharmacyMedicine(PharmacyMedicine pharmacyMedicine);

    List<MedicineReservation> findAllByPatient(Patient patient);
}
