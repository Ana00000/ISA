package com.example.demo.model;

import com.example.demo.dto.UserDTO;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SystemAdmin extends User{

    @Column(name= "isLoggedFirstTime", unique = false ,nullable = false)
    private boolean isLoggedFirstTime;

    public boolean isLoggedFirstTime() {
        return isLoggedFirstTime;
    }

    public void setLoggedFirstTime(boolean loggedFirstTime) {
        isLoggedFirstTime = loggedFirstTime;
    }

    public SystemAdmin(){
    }

    public  SystemAdmin(UserDTO userDTO){
        super(userDTO);
    }

}
