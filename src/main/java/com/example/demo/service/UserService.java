package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
	User findOne(Long id);

	User findOneByPassword(String password);

	List<User> findAll();

	Page<User> findAll(Pageable page);

	List<User> findAllByName(String name);

	List<User> findAllByLastName(String lastName);

	UserDTO findByEmail(String email);

	List<User> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

	User save(User user);

	void remove(Long id);

	User login(UserDTO userDTO);
}
