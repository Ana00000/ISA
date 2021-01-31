package com.example.demo.dto;

import com.example.demo.model.User;

public abstract class UserDTO {
	private Long id;
	private String name;
	private String lastName;
	private String email;
	 
	public UserDTO() {
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getLastName(), user.getEmail());
	}
	
	public UserDTO(Long id, String name, String lastName, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
