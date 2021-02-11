package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.MedicineDTO;
import com.example.demo.model.Allergy;
import com.example.demo.model.Medicine;
import com.example.demo.service.AllergyService;
import com.example.demo.service.MedicineService;
import com.example.demo.service.PatientService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/medicine", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineController {
	
	private MedicineService medicineService;
	private PatientService patientService;
	private AllergyService allergyService;
    
	@Autowired
	public MedicineController(MedicineService medicineService,
			PatientService patientService, AllergyService allergyService) {
		this.medicineService = medicineService;
		this.patientService = patientService;
		this.allergyService = allergyService;
	}

	@GetMapping
	public ResponseEntity<List<MedicineDTO>> getMedicine() {
		List<Medicine> medicine = medicineService.findAll();

		List<MedicineDTO> medicineDTOS = new ArrayList<>();
		for(Medicine m : medicine){
			medicineDTOS.add(new MedicineDTO(m));
		}
		return new ResponseEntity<>(medicineDTOS, HttpStatus.OK);
	}
	

	@GetMapping(value = "/healthyMedicineForPatient/{id}")
	public ResponseEntity<List<MedicineDTO>> getHealthyMedicineForPatient(@PathVariable Long id) {
		
		List<Medicine> medicines = medicineService.findAll();
		
        for(Medicine m: medicineService.findAll()) {
	        for(Allergy a: allergyService.findAll()) { 
	        	if(m.getIngredients().contains(a.getMedicineIngredient())
	        	& patientService.findOne(id).getAllergies().contains(a)) {
	        		medicines.remove(m);
	        	}
	        }
        }
        
		List<MedicineDTO> medicinesDTO = new ArrayList<>();
		for(Medicine m : medicines){
			medicinesDTO.add(new MedicineDTO(m));
		}
		return new ResponseEntity<>(medicinesDTO, HttpStatus.OK);
	}

}