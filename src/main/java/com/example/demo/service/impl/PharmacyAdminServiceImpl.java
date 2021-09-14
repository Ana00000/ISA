package com.example.demo.service.impl;

import com.example.demo.dto.PharmacyAdminDTO;
import com.example.demo.model.Authority;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyAdmin;
import com.example.demo.repository.PharmacyAdminRepository;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.PharmacyAdminService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyAdminServiceImpl implements PharmacyAdminService {

    private final PharmacyAdminRepository pharmacyAdminRepository;
    private final PharmacyRepository pharmacyRepository;
    private final UserService userService;

    @Autowired
    public PharmacyAdminServiceImpl(PharmacyAdminRepository pharmacyAdminRepository, PharmacyRepository pharmacyRepository, UserService userService) {
        this.pharmacyAdminRepository = pharmacyAdminRepository;
        this.pharmacyRepository = pharmacyRepository;
        this.userService = userService;
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
    public PharmacyAdmin findOneByEmail(String email) { return pharmacyAdminRepository.findByEmail(email); }

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

    @Override
    public PharmacyAdmin addPharmacyAdmin(PharmacyAdminDTO pharmacyAdminDTO) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyAdminDTO.getPharmacyId()).get();
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin(pharmacyAdminDTO, pharmacy);
        userService.save(pharmacyAdmin);
        return pharmacyAdmin;
    }
}
