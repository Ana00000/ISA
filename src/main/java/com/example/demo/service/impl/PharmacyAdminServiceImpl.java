package com.example.demo.service.impl;

import com.example.demo.model.PharmacyAdmin;
import com.example.demo.repository.PharmacyAdminRepository;
import com.example.demo.service.PharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyAdminServiceImpl implements PharmacyAdminService {

    private final PharmacyAdminRepository pharmacyAdminRepository;

    @Autowired
    public PharmacyAdminServiceImpl(PharmacyAdminRepository pharmacyAdminRepository) {
        this.pharmacyAdminRepository = pharmacyAdminRepository;
    }

    @Override
    public PharmacyAdmin findOne(Long id) {
        return pharmacyAdminRepository.findById(id).orElse(null);
    }

    @Override
    public PharmacyAdmin findOneByPassword(String password) {
        return pharmacyAdminRepository.findOneByPassword(password);
    }

    @Override
    public List<PharmacyAdmin> findAll() {
        return pharmacyAdminRepository.findAll();
    }

    @Override
    public Page<PharmacyAdmin> findAll(Pageable page) {
        return pharmacyAdminRepository.findAll(page);
    }

    @Override
    public List<PharmacyAdmin> findAllByName(String name) {
        return pharmacyAdminRepository.findAllByName(name);
    }

    @Override
    public List<PharmacyAdmin> findAllByLastName(String lastName) {
        return pharmacyAdminRepository.findAllByLastName(lastName);
    }

    @Override
    public List<PharmacyAdmin> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
        return null;
    }

    @Override
    public PharmacyAdmin save(PharmacyAdmin pharmacyAdmin) {
        pharmacyAdminRepository.save(pharmacyAdmin);
        return pharmacyAdmin;
    }

    public void remove(Long id) {
        pharmacyAdminRepository.deleteById(id);
    }
}
