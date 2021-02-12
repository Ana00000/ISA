package com.example.demo.model;

import com.example.demo.dto.UserDTO;
import org.junit.Ignore;

import javax.persistence.Entity;

@Entity
@Ignore
public class Supplier extends User {

    public Supplier() {
    }

    public Supplier(UserDTO userDTO) {
        super(userDTO);
    }

    public Supplier(Long id, String name, String lastName, String email, String password, String address, String phoneNumber, boolean active, String hashString) {
        super(id, name, lastName, email, password, address, phoneNumber, active, hashString);
    }
}
