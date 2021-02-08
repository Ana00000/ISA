package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Patient;
import com.example.demo.model.Pharmacist;
import com.example.demo.model.PharmacyAdmin;
import com.example.demo.model.User;
import com.example.demo.security.ResourceConflictException;
import com.example.demo.security.TokenUtils;
import com.example.demo.security.UserTokenState;
import com.example.demo.service.DermatologistService;
import com.example.demo.service.PatientService;
import com.example.demo.service.PharmacyAdminService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
    private final UserService userService;
    
	@Autowired
    private final PatientService patientService;
	
	@Autowired
	private final DermatologistService dermatologistService;
	
	@Autowired
	private final PharmacyAdminService pharmacyAdminService;

	 
    @Autowired
    public UserController(UserService userService, PatientService patientService, DermatologistService dermatologistService, PharmacyAdminService pharmacyAdminService) {
        this.pharmacyAdminService = pharmacyAdminService;
		this.dermatologistService = dermatologistService;
		this.userService = userService;
        this.patientService = patientService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> findByEmail(String email) {
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
    }
    
    @GetMapping("/redirectMeToMyHomePage")
    public String GetLoggedUser(Authentication authentication) {
    	String email = authentication.getName();
    	User user = userService.findByEmail(email);
    	if(user.getClass() == Dermatologist.class) {
    		return "http://localhost:8080/";
    	}
    	if (user.getClass() == Patient.class) {
    		return "http://localhost:8080/patientHomePage";
    	}
    	if(user.getClass() == Pharmacist.class) {
    		return "http://localhost:8080/";
    	}
    	if(user.getClass() == PharmacyAdmin.class) {
//    		User user2 = pharmacyAdminService.findByEmail(email);
//    		return "http://localhost:8080/pharmacyAdmin/profile/"+user2.getId();
    		return "http://localhost:8080/pharmacyAdmin/profile/11";
    	}
    	return "http://localhost:8080/";
    }
    
    @PostMapping("/login")
    public ResponseEntity<UserTokenState> login(@RequestBody UserDTO authenticationRequest,
			HttpServletResponse response) {
    	System.out.println("------- login -------");
    	// 
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// Kreiraj token zaa tog korisnika
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }
    
    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByEmail(userRequest.getEmail());

		if (existUser != null) {
			throw new ResourceConflictException(existUser.getId(), "Username already exists");
		}

		User user = this.userService.save(new Patient(userRequest));
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());	//is this redirection ???
		return new ResponseEntity<>(user, HttpStatus.CREATED);
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

}
