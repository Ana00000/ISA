package com.example.demo.service.impl;

import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public Pharmacy findOne(Long id) {
        return pharmacyRepository.findById(id).orElseGet(null);
    }

    //@Override
    public List<Pharmacy> findAll() {
        return pharmacyRepository.findAll();
    }

    @Override
    public List<Pharmacy> findAllByName(String name) {
        return pharmacyRepository.findAllByName(name);
    }

    @Override
    public List<Pharmacy> findAllByCountry(String country) {
        return pharmacyRepository.findAllByCountry(country);
    }

    @Override
    public List<Pharmacy> findAllByCity(String city) {
        return pharmacyRepository.findAllByCity(city);
    }

    @Override
    public List<Medicine> findMedicineIdById(Long pharmacyId) { return pharmacyRepository.findMedicineAllById(pharmacyId); }

    @Override
    public void save(Pharmacy pharmacy) {
        pharmacyRepository.save(pharmacy);
    }

    @Override
    public void update(Pharmacy pharmacy) {
        return;
    }

    @Override
    public void remove(Long id) {
        pharmacyRepository.deleteById(id);
    }

    @Override
    public void findByFreePharmacists(Time startTime, Time endTime, Date date){

    }

    @Override
    public List<Pharmacy> findAllPharmaciesByDermatologist(Long dermatologistId) {
        return pharmacyRepository.findAllPharmaciesByDermatologist(dermatologistId);
    }
}
