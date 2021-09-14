package com.example.demo.service.impl;

import com.example.demo.model.Authority;
import com.example.demo.model.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private AuthorityService authorityService;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, AuthorityService authorityService) {
        this.supplierRepository = supplierRepository;
        this.authorityService = authorityService;
    }

    @Override
    public Supplier findOneByPassword(String password) {
        return supplierRepository.findOneByPassword(password);
    }

    @Override
    public Supplier findOne(Long id) {
        return supplierRepository.findOneById(id);
    }

    @Override
    public Page<Supplier> findAll(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }

    @Override
    public List<Supplier> findAllByName(String name) {
        return supplierRepository.findAllByName(name);
    }

    @Override
    public List<Supplier> findAllByLastName(String lastName) {
        return supplierRepository.findAllByLastName(lastName);
    }

    @Override
    public List<Supplier> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
        return supplierRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
    }

    @Override
    public Supplier findByEmail(String email) {
        return supplierRepository.findByEmail(email);
    }

    @Override
    public Supplier findByEmailAndPassword(String email, String password) {
        return supplierRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Supplier save(Supplier supplier) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.findByName("ROLE_SUPPLIER"));
        supplier.setAuthorities(authorities);
        return supplierRepository.save(supplier);
    }
}
