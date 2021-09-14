package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.SystemAdmin;
import com.example.demo.service.SystemAdminService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/SystemAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemAdminController {
    private SystemAdminService systemAdminService;
    private UserService userService;
    @Autowired
    public SystemAdminController(SystemAdminService systemAdminService, UserService userService){
        this.systemAdminService = systemAdminService;
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<UserDTO> addSystemAdmin(@RequestBody UserDTO userDTO){
        SystemAdmin systemAdmin = new SystemAdmin(userDTO);
        systemAdmin.setActive(true);
        userService.save(systemAdmin);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/editPassword/{newPassword}")
    public ResponseEntity<SystemAdmin> edit(Authentication authentication,@PathVariable String newPassword){
        SystemAdmin systemAdmin = systemAdminService.findByEmail(authentication.getName());
        systemAdmin.setPassword(newPassword);
        systemAdmin.setLoggedFirstTime(false);
        userService.save(systemAdmin);
        return new ResponseEntity<>(systemAdmin,HttpStatus.OK);
    }

}
