package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    
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
	
	public List<User> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
		return userRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
	}
	
	public List<User> findAllByEmail(String email) {
		return userRepository.findAllByEmail(email);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void remove(Long id) {
		userRepository.deleteById(id);
	}
}