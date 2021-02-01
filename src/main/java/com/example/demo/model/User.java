package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.dto.UserDTO;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Table(name="hospitalUsers") 
@Inheritance(strategy=TABLE_PER_CLASS)
public abstract class User {
	
    @Id
    @SequenceGenerator(name = "usersIdSeqGen", sequenceName = "usersIdSeq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersIdSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", unique=false, nullable=false)
    private String name;

    @Column(name="lastName", unique=false, nullable=false)
    private String lastName;
    
    @Column(name="email", unique=true, nullable=false)
    private String email;

    @Column(name="password", unique=false, nullable=false)
    private String password;
    
    @Column(name="address", unique=false, nullable=false)
    private String address;
    
    @Column(name="phoneNumber", unique=false, nullable=false)
    private String phoneNumber;

	public User() {
	}
	
	public User(UserDTO userDTO) {
		this.id = userDTO.getId();
		this.name = userDTO.getName();
		this.lastName = userDTO.getLastName();
		this.email = userDTO.getEmail();
		this.password = userDTO.getPassword();
		this.address= userDTO.getAddress();
		this.phoneNumber= userDTO.getPhoneNumber();
	}
	
	public User(Long id, String name, String lastName, String email, String password, String address, String phoneNumber) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}

	
}