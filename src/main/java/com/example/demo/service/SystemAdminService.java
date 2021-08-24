package com.example.demo.service;

import com.example.demo.model.Supplier;
import com.example.demo.model.SystemAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SystemAdminService{
    SystemAdmin findOneByPassword(String password);

    SystemAdmin findOne(Long id);

    List<SystemAdmin> findAllByName(String name);

    List<SystemAdmin> findAllByLastName(String lastName);

    List<SystemAdmin> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

    SystemAdmin findByEmail(String email);

    SystemAdmin findByEmailAndPassword(String email, String password);

    SystemAdmin save (SystemAdmin systemAdmin);
}
