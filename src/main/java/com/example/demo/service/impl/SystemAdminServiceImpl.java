package com.example.demo.service.impl;

import com.example.demo.model.SystemAdmin;
import com.example.demo.repository.SystemAdminRepository;
import com.example.demo.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SystemAdminServiceImpl implements SystemAdminService {

    @Autowired
    private SystemAdminRepository systemAdminRepository;
    @Override
    public SystemAdmin findOneByPassword(String password) {
        return systemAdminRepository.findOneByPassword(password);
    }

    @Override
    public SystemAdmin findOne(Long id) {
        return systemAdminRepository.findOneById(id);
    }

    @Override
    public List<SystemAdmin> findAllByName(String name) {
        return systemAdminRepository.findAllByName(name);
    }

    @Override
    public List<SystemAdmin> findAllByLastName(String lastName) {
        return systemAdminRepository.findAllByLastName(lastName);
    }

    @Override
    public List<SystemAdmin> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
        return systemAdminRepository.findByNameAndLastNameAllIgnoringCase(name,lastName);
    }

    @Override
    public SystemAdmin findByEmail(String email) {
        return systemAdminRepository.findByEmail(email);
    }

    @Override
    public SystemAdmin findByEmailAndPassword(String email, String password) {
        return systemAdminRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public SystemAdmin save(SystemAdmin systemAdmin) {
        return systemAdminRepository.save(systemAdmin);
    }
}
