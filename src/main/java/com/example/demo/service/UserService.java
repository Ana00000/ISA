package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.User;

public interface UserService {
	
	User findOne(Long id);
	    
	User findOneByPassword(String password);

	List<User> findAll();
	
	Page<User> findAll(Pageable page);
	
	List<User> findAllByName(String name);
	
	List<User> findAllByLastName(String lastName);
	
	List<User> findByNameAndLastNameAllIgnoringCase(String name, String lastName);
	
	List<User> findAllByEmail(String email);

	User save(User user);

	void remove(Long id);
}