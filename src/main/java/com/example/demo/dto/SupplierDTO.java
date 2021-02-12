package com.example.demo.dto;

import com.example.demo.model.User;

public class SupplierDTO extends UserDTO{


    public SupplierDTO() {
    }

    public SupplierDTO(User user) {
        super(user);
    }

    public SupplierDTO(Long id, String name, String lastName, String email, String password, String address, String phoneNumber, Boolean active, String hashString) {
        super(id, name, lastName, email, password, address, phoneNumber, active, hashString);
    }
}
