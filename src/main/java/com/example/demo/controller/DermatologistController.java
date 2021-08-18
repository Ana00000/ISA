package com.example.demo.controller;

import com.example.demo.dto.DermatologistDTO;
import com.example.demo.dto.PharmacyAdminDTO;
import com.example.demo.model.Dermatologist;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyAdmin;
import com.example.demo.service.DermatologistService;
import com.example.demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/dermatologists", produces = MediaType.APPLICATION_JSON_VALUE)
public class DermatologistController {
	
	private final DermatologistService dermatologistService;
	private final PharmacyService pharmacyService;

	@Autowired
	public DermatologistController(DermatologistService dermatologistService, PharmacyService pharmacyService) {
		this.dermatologistService = dermatologistService;
		this.pharmacyService = pharmacyService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<DermatologistDTO>> getAllDermatologists() {

		List<Dermatologist> dermatologists = dermatologistService.findAll();

		List<DermatologistDTO> dermatologistsDTO = new ArrayList<>();
		for (Dermatologist d : dermatologists) {
			dermatologistsDTO.add(new DermatologistDTO(d));
		}

		return new ResponseEntity<>(dermatologistsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DermatologistDTO> getDermatologist(@PathVariable Long id) {

		Dermatologist dermatologist = dermatologistService.findOne(id);

		if (dermatologist == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new DermatologistDTO(dermatologist), HttpStatus.OK);
	}

	@GetMapping(value = "/getByPharmacy={id}")
	public ResponseEntity<List<DermatologistDTO>> getDermatologistFromPharmacy(@PathVariable Long id) {
		Pharmacy pharmacy = pharmacyService.findOne(id);
		List<Pharmacy> pharmacyList = new ArrayList<>();
		pharmacyList.add(pharmacy);
		List<Dermatologist> dermatologists = dermatologistService.findAllByPharmacies(pharmacyList);
		List<DermatologistDTO> dermatologistDTOS = new ArrayList<>();

		if (dermatologists == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {

			for (Dermatologist d: dermatologists) {
				DermatologistDTO dto = new DermatologistDTO(d);
				dermatologistDTOS.add(dto);
			}
		}

		return new ResponseEntity<>(dermatologistDTOS, HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<DermatologistDTO> updateDermatologist(@RequestBody DermatologistDTO dermatologistDTO) {

		Dermatologist dermatologist = dermatologistService.findOne(dermatologistDTO.getId());
		
		if (dermatologist == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		setOfValidInputs(dermatologist, dermatologistDTO);
		dermatologist.setId(dermatologistDTO.getId());
		dermatologist.setType(dermatologistDTO.getType());
		dermatologist.setActive(dermatologistDTO.isActive());

		dermatologist = dermatologistService.save(dermatologist);
		return new ResponseEntity<>(new DermatologistDTO(dermatologist), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDermatologist(@PathVariable Long id) {

		Dermatologist dermatologist = dermatologistService.findOne(id);

		if (dermatologist != null) {
			dermatologistService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/addDermatolog")
	public ResponseEntity<DermatologistDTO> addDermatologist(@RequestBody DermatologistDTO dermatologistDTO){
		Dermatologist dermatologist = new Dermatologist(dermatologistDTO);
		dermatologist.setType("dermatologist");
		dermatologistService.save(dermatologist);
		return new ResponseEntity<>(dermatologistDTO,HttpStatus.CREATED);
	}
	private void setOfValidInputs(Dermatologist dermatologist, DermatologistDTO dermatologistDTO) {
		setOfValidName(dermatologist, dermatologistDTO.getName());
		setOfValidLastName(dermatologist, dermatologistDTO.getLastName());
		setOfValidEmail(dermatologist, dermatologistDTO.getEmail());
		setOfValidPassword(dermatologist, dermatologistDTO.getPassword());
		setOfValidAddress(dermatologist, dermatologistDTO.getAddress());
		setOfValidPhoneNumber(dermatologist, dermatologistDTO.getPhoneNumber());
    }
	
	private void setOfValidName(Dermatologist dermatologist, String name) {
        if(name.length() < 2)
        {
        	System.out.println("Your name should contain at least 2 characters!");
            return;
        }else if(name.length() > 20)
        {
        	System.out.println("Your name shouldn't contain more than 20 characters!");
            return;
        }else 
        	dermatologist.setName(name);
    }
	
	private void setOfValidLastName(Dermatologist dermatologist, String lastName) {
        if(lastName.length() < 2)
        {
        	System.out.println("Your last name should contain at least 2 characters!");
            return;
        }else if(lastName.length() > 20)
        {
        	System.out.println("Your last name shouldn't contain more than 20 characters!");
            return;
        }else 
        	dermatologist.setLastName(lastName);
    }
	
	private void setOfValidEmail(Dermatologist dermatologist, String email) {
        if(email.length() < 5)
        {
        	System.out.println("Your email should contain at least 5 characters!");
            return;
        }else if(email.length() > 35)
        {
        	System.out.println("Your email shouldn't contain more than 35 characters!");
            return;
        }else 
        	dermatologist.setEmail(email);
    }
	
	private void setOfValidPassword(Dermatologist dermatologist, String password) {
        if(password.length() < 3)
        {
        	System.out.println("Your password should contain at least 3 characters!");
            return;
        }else if(password.length() > 70)
        {
        	System.out.println("Your password shouldn't contain more than 70 characters!");
            return;
        }else 
        	dermatologist.setPassword(password);
    }
	
	private void setOfValidAddress(Dermatologist dermatologist, String address) {
        if(address.length() < 3)
        {
        	System.out.println("Your address should contain at least 3 characters!");
            return;
        }else if(address.length() > 50)
        {
        	System.out.println("Your address shouldn't contain more than 50 characters!");
            return;
        }else
        	dermatologist.setAddress(address);
    }
	
	private void setOfValidPhoneNumber(Dermatologist dermatologist, String phoneNumber) {
		int flag = validationOfPhoneNumberElements(phoneNumber);
		flag += validationOfPhoneNumberLength(phoneNumber);
        if(flag == 0)
        	dermatologist.setPhoneNumber(phoneNumber);
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
		if(phoneNumber.length() < 9)
        {
        	System.out.println("Your phone number should contain at least 9 characters!");
            return 1;
        }else if(phoneNumber.length() > 11)
        {
        	System.out.println("Your phone number shouldn't contain more than 11 characters!");
            return 1;
        }
		return 0;
	}
}