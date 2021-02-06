package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PharmacistDTO;
import com.example.demo.model.Pharmacist;
import com.example.demo.service.PharmacistService;
import org.springframework.http.MediaType;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/pharmacists", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacistController {
	
	private final PharmacistService pharmacistService;
    
	@Autowired
	public PharmacistController(PharmacistService pharmacistService) {
		this.pharmacistService = pharmacistService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<PharmacistDTO>> getAllPharmacists() {

		List<Pharmacist> pharmacists = pharmacistService.findAll();

		List<PharmacistDTO> pharmacistsDTO = new ArrayList<>();
		for (Pharmacist p : pharmacists) {
			pharmacistsDTO.add(new PharmacistDTO(p));
		}

		return new ResponseEntity<>(pharmacistsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PharmacistDTO> getPharmacist(@PathVariable Long id) {
		Pharmacist pharmacist = pharmacistService.findOne(id);

		if (pharmacist == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new PharmacistDTO(pharmacist), HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<PharmacistDTO> updatePharmacist(@RequestBody PharmacistDTO pharmacistDTO) {

		Pharmacist pharmacist = pharmacistService.findOne(pharmacistDTO.getId());

		if (pharmacist == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		setOfValidInputs(pharmacist, pharmacistDTO);
		pharmacist.setId(pharmacistDTO.getId());
		pharmacist.setType(pharmacistDTO.getType());
		pharmacist.setActive(pharmacistDTO.isActive());

		pharmacist = pharmacistService.save(pharmacist);
		return new ResponseEntity<>(new PharmacistDTO(pharmacist), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePharmacist(@PathVariable Long id) {

		Pharmacist pharmacist = pharmacistService.findOne(id);

		if (pharmacist != null) {
			pharmacistService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	private void setOfValidInputs(Pharmacist pharmacist, PharmacistDTO pharmacistDTO) {
		setOfValidName(pharmacist, pharmacistDTO.getName());
		setOfValidLastName(pharmacist, pharmacistDTO.getLastName());
		setOfValidEmail(pharmacist, pharmacistDTO.getEmail());
		setOfValidPassword(pharmacist, pharmacistDTO.getPassword());
		setOfValidAddress(pharmacist, pharmacistDTO.getAddress());
		setOfValidPhoneNumber(pharmacist, pharmacistDTO.getPhoneNumber());
    }
	
	private void setOfValidName(Pharmacist pharmacist, String name) {
        if(name.length() < 2)
        {
        	System.out.println("Your name should contain at least 2 characters!");
            return;
        }else if(name.length() > 20)
        {
        	System.out.println("Your name shouldn't contain more than 20 characters!");
            return;
        }else 
        	pharmacist.setName(name);
    }
	
	private void setOfValidLastName(Pharmacist pharmacist, String lastName) {
        if(lastName.length() < 2)
        {
        	System.out.println("Your last name should contain at least 2 characters!");
            return;
        }else if(lastName.length() > 20)
        {
        	System.out.println("Your last name shouldn't contain more than 20 characters!");
            return;
        }else 
    		pharmacist.setLastName(lastName);
    }
	
	private void setOfValidEmail(Pharmacist pharmacist, String email) {
        if(email.length() < 5)
        {
        	System.out.println("Your email should contain at least 5 characters!");
            return;
        }else if(email.length() > 35)
        {
        	System.out.println("Your email shouldn't contain more than 35 characters!");
            return;
        }else 
    		pharmacist.setEmail(email);
    }
	
	private void setOfValidPassword(Pharmacist pharmacist, String password) {
        if(password.length() < 3)
        {
        	System.out.println("Your password should contain at least 3 characters!");
            return;
        }else if(password.length() > 20)
        {
        	System.out.println("Your password shouldn't contain more than 20 characters!");
            return;
        }else 
        	pharmacist.setPassword(password);
    }
	
	private void setOfValidAddress(Pharmacist pharmacist, String address) {
        if(address.length() < 3)
        {
        	System.out.println("Your address should contain at least 3 characters!");
            return;
        }else if(address.length() > 50)
        {
        	System.out.println("Your address shouldn't contain more than 50 characters!");
            return;
        }else
    		pharmacist.setAddress(address);
    }
	
	private void setOfValidPhoneNumber(Pharmacist pharmacist, String phoneNumber) {
		int flag = validationOfPhoneNumberElements(phoneNumber);
		flag += validationOfPhoneNumberLength(phoneNumber);
        if(flag == 0)
        	pharmacist.setPhoneNumber(phoneNumber);
    }
	
	private int validationOfPhoneNumberElements(String phoneNumber) {
		for(int i = 0; i < phoneNumber.length(); i++)
        {
			if (!(phoneNumber.matches("[0-9]+") || phoneNumber.contains("/") || phoneNumber.contains("-"))) {
			    System.out.println("Your phone number can contain only numbers and / - characters!");
			    return 1;
			}
        }
		return 0;
	}
	
	private int validationOfPhoneNumberLength(String phoneNumber) {
		if(phoneNumber.length() < 6)
        {
        	System.out.println("Your phone number should contain at least 6 characters!");
            return 1;
        }else if(phoneNumber.length() > 10)
        {
        	System.out.println("Your phone number shouldn't contain more than 10 characters!");
            return 1;
        }
		return 0;
	}
}