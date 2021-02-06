package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.model.enums.MedicineReservationValue;
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
        medicineReservation.setReservationStatus(new MedicineReservationStatus(1L, MedicineReservationValue.ACTIVE));
        Patient patient = new Patient();
        patient.setId(4L);
        medicineReservation.setPatient(patient);
        return medicineReservationRepository.save(medicineReservation);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<PharmacyMedicine> findOnePharmacyMedicine(PharmacyMedicinePK medicineReservationPK) {
        //return pharmacyMedicineRepository.findOne(pharmacyMedicine);
        return pharmacyMedicineRepository.findById(medicineReservationPK);
    }

    @Override
    public PharmacyMedicine updatePharmacyMedicine(PharmacyMedicine pharmacyMedicine){
//        PharmacyMedicinePK pharmacyMedicinePK = new PharmacyMedicinePK(pharmacyMedicine.getMedicine(), pharmacyMedicine.getPharmacy());
//        Optional<PharmacyMedicine> pm = pharmacyMedicineRepository.findById(pharmacyMedicinePK);
//        pm.get().setMedicine(pharmacyMedicine.getMedicine());
        return pharmacyMedicineRepository.save(pharmacyMedicine);
    }
}
