package com.example.demo.service;

import com.example.demo.model.Authority;

public interface AuthorityService {
    Authority findById(Long id);
    Authority findByName(String name);
}
