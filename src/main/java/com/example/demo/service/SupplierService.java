package com.example.demo.service;

import com.example.demo.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupplierService {

    Supplier findOneByPassword(String password);

    Supplier findOne(Long id);

    Page<Supplier> findAll(Pageable pageable);

    List<Supplier> findAllByName(String name);

    List<Supplier> findAllByLastName(String lastName);

    List<Supplier> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

    Supplier findByEmail(String email);

    Supplier findByEmailAndPassword(String email, String password);

    Supplier save (Supplier supplier);
}
