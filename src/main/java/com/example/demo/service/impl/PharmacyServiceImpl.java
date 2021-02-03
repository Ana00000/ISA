package com.example.demo.service.impl;

import com.example.demo.model.Pharmacy;
import com.example.demo.repository.PharmacistRepository;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public Pharmacy findOne(Long id) {
        return pharmacyRepository.findById(id).orElseGet(null);
    }

    @Override
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
}
