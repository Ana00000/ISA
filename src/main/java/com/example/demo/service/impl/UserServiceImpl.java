package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.DermatologistDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.PharmacistDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.*;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOne(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    public User findOneByPassword(String password) {
        return userRepository.findOneByPassword(password);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAll(Pageable page) {
        return userRepository.findAll(page);
    }

    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    public List<User> findAllByLastName(String lastName) {
        return userRepository.findAllByLastName(lastName);
    }

    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if(user != null){
            return new UserDTO(user);
        }

        return null;
    }

    public List<User> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
        return userRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.findByName("ROLE_USER"));
        user.setAuthorities(authorities);
        return userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User login(UserDTO userDTO) {
        return userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
    }
}