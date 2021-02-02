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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

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
            if(!user.isActive()) {
            	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO){
    	try {
    		String hashString = givenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect();
    		userDTO.setHashString(hashString);
    		userDTO.setActive(true);	//set it false when email verification is done !!!
			if(userService.login(userDTO) != null) {
				return new ResponseEntity<String>("User name not available",HttpStatus.BAD_REQUEST);
			}
    		Patient patient= new Patient(userDTO);
			patientService.save(patient);
    		
    		return new ResponseEntity<String>("Successfully created",HttpStatus.OK);
		} catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    
    public String givenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 30;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
        return generatedString;
    }
    
    /*public static void send(String from,String password,String to,String sub,String msg){  
    	Properties props = new Properties();
    	Session session= Session.getDefaultInstance(System.getProperties());

    	try {
    	  Message msg = new MimeMessage(session);
    	  msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
    	  msg.addRecipient(Message.RecipientType.TO,
    	                   new InternetAddress("user@example.com", "Mr. User"));
    	  msg.setSubject("Your Example.com account has been activated");
    	  msg.setText("This is a test");
    	  Transport.send(msg);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return;
    	}
           
  }  */

}
