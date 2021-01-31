package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dto.DermatologistDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.PharmacistDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Pharmacist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
        return new UserDTO(userRepository.findByEmail(email));
    }

    public List<User> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
        return userRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        System.out.println(userDTO);

        String email = userDTO.getEmail();
        String password = userDTO.getPassword();

        User user = userRepository.findByEmailAndPassword(email, password);
        System.out.println(user);

        if (user == null) {
            throw new RuntimeException("User with that email and password doesn't exist");
        }

        UserDTO userDTO1;

        if (Patient.class.equals(user.getClass())) {
            userDTO1 = new PatientDTO(user);
            System.out.println(userDTO1);
        } else if (Pharmacist.class.equals(user.getClass())) {
            userDTO1 = new PharmacistDTO((Doctor) user);
            System.out.println(userDTO1);
        } else {
            userDTO1 = new DermatologistDTO((Doctor) user);
            System.out.println(userDTO1);
        }

        return userDTO1;
    }
}