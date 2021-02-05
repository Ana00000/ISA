package com.example.demo.service;

import com.example.demo.model.PharmacyAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PharmacyAdminService  {
    PharmacyAdmin findOne(Long id);

    PharmacyAdmin findOneByPassword(String password);

    List<PharmacyAdmin> findAll();

    Page<PharmacyAdmin> findAll(Pageable page);

    List<PharmacyAdmin> findAllByName(String name);

    List<PharmacyAdmin> findAllByLastName(String lastName);

    List<PharmacyAdmin> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

    PharmacyAdmin save(PharmacyAdmin pharmacyAdmin);

    void remove(Long id);
}
