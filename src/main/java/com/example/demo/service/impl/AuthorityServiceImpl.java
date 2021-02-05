package com.example.demo.service.impl;

import com.example.demo.model.Authority;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority findById(Long id) {
        return authorityRepository.getOne(id);
    }

    @Override
    public Authority findByName(String name) {
        return authorityRepository.findByName(name);
    }
}
