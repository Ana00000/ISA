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

import com.example.demo.repository.DermatologistRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.PharmacistRepository;
import com.example.demo.repository.PharmacyAdminRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final DermatologistRepository dermatologistRepository;
    private final PatientRepository patientRepository;
    private final PharmacistRepository pharmacistRepository;
    private final PharmacyAdminRepository pharmacyAdminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, DoctorRepository doctorRepository, DermatologistRepository dermatologistRepository, 
    		PatientRepository patientRepository, PharmacistRepository pharmacistRepository, PharmacyAdminRepository pharmacyAdminRepository) {
        this.patientRepository = patientRepository;
		this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.dermatologistRepository = dermatologistRepository;
        this.pharmacistRepository = pharmacistRepository;
        this.pharmacyAdminRepository = pharmacyAdminRepository;
    }

    public User findOne(Long id) {
    	List<User> users = findAll();
    	for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
        return null;
    }

    public User findOneByPassword(String password) {
    	List<User> users = findAll();
    	for (User user : users) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
        return null;
    }

    public List<User> findAll() {
    	List<User> retList = new ArrayList();
    	retList.addAll(doctorRepository.findAll());
    	retList.addAll(dermatologistRepository.findAll());
    	retList.addAll(patientRepository.findAll());
    	retList.addAll(pharmacistRepository.findAll());
    	retList.addAll(pharmacyAdminRepository.findAll());
        return retList;
    }

    public Page<User> findAll(Pageable page) {
        return userRepository.findAll(page);
    }

    public List<User> findAllByName(String name) {
    	List<User> users = findAll();
    	List<User> retList = new ArrayList<User>();
    	for (User user : users) {
			if(user.getName().toLowerCase().equals(name.toLowerCase())) {
				retList.add(user);
			}
		}
        return retList;
    }

    public List<User> findAllByLastName(String lastName) {
    	List<User> users = findAll();
    	List<User> retList = new ArrayList<User>();
    	for (User user : users) {
			if(user.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				retList.add(user);
			}
		}
        return retList;
    }

    public User findByEmail(String email) {
    	List<User> users = findAll();
    	for (User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
        return null;
    }

    public List<User> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
    	List<User> users = findAll();
    	List<User> retList = new ArrayList<User>();
    	for (User user : users) {
			if(user.getLastName().toLowerCase().equals(lastName.toLowerCase()) 
					&& user.getName().toLowerCase().equals(name.toLowerCase())) {
				retList.add(user);
			}
		}
        return retList;
    }
    public User save(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.findByName("ROLE_USER"));
        user.setAuthorities(authorities);
    	if(user.getClass() == Dermatologist.class) {
    		return dermatologistRepository.save((Dermatologist)user);
    	}
    	if (user.getClass() == Patient.class) {
    		return patientRepository.save((Patient)user);
    	}
    	if(user.getClass() == Pharmacist.class) {
    		return pharmacistRepository.save((Pharmacist)user);
    	}
    	if(user.getClass() == PharmacyAdmin.class) {
    		 return pharmacyAdminRepository.save((PharmacyAdmin)user);
    	}
		return userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User login(UserDTO userDTO) {
    	List<User> users = findAll();
    	for (User user : users) {
			if(user.getUsername().equals(userDTO.getEmail()) && user.getPassword().equals(userDTO.getPassword())) {
				return user;
			}
		}
        return null;
    }
}