package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneById(Long id);
	
	Page<User> findAll(Pageable pageable);
	
	List<User> findAllByName(String name);
	
	List<User> findAllByLastName(String lastName);
	
	List<User> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

	List<User> findAllByEmail(String email);
}
