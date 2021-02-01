package com.example.demo.dto;

import com.example.demo.model.User;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {
	private Long id;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private String phoneNumber;

	public UserDTO() {
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(),user.getAddress(),user.getPhoneNumber());
	}
	
	public UserDTO(Long id, String name, String lastName, String email, String password, String address, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}

	
}
