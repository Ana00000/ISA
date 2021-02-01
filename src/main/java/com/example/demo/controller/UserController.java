package com.example.demo.controller;


import com.example.demo.dto.DermatologistDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.PharmacistDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Pharmacist;
import com.example.demo.model.User;
import com.example.demo.service.PatientService;
import com.example.demo.service.UserService;

import jdk.jfr.Registered;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

    private final UserService userService;
    
    private final PatientService patientService;

    @Autowired
    public UserController(UserService userService, PatientService patientService) {
        this.userService = userService;
        this.patientService = patientService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<UserDTO> findByEmail(String email) {
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
        UserDTO userDto;

        try {
            User user = userService.login(userDTO);

            if (user == null) {
                throw new RuntimeException("User with that email and password doesn't exist");
            }

            if (Patient.class.equals(user.getClass())) {
                userDto = new PatientDTO(user);
            } else if (Pharmacist.class.equals(user.getClass())) {
                userDto = new PharmacistDTO((Doctor) user);
            } else {
                userDto = new DermatologistDTO((Doctor) user);
            }
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
    	try {
			Patient patient= new Patient(userDTO);
			System.out.println(patient);
			patientService.save(patient);
    		
    		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
		} catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
