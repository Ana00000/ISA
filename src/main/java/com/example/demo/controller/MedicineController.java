package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.MedicineToAddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.model.Allergy;
import com.example.demo.model.Medicine;
import com.example.demo.service.AllergyService;
import com.example.demo.service.MedicineService;
import com.example.demo.service.PatientService;
import com.example.demo.service.PharmacyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/medicine", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineController {
	
	private final MedicineService medicineService;
	private final PharmacyService pharmacyService;
	private final PatientService patientService;
	private final AllergyService allergyService;

	@Autowired
	public MedicineController(MedicineService medicineService,
							  PatientService patientService,
							  AllergyService allergyService,
							  PharmacyService pharmacyService) {
		this.medicineService = medicineService;
		this.pharmacyService = pharmacyService;
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

	@GetMapping(value = "/findByPharmacyId={pharmacyId}")
	public ResponseEntity<List<MedicineDTO>> getMedicinebyPharmacyId(@PathVariable Long pharmacyId) {
		System.out.println("---------- Find Medicine By Id: " + pharmacyId + " ----------");
		List<Medicine> medicineList = pharmacyService.findMedicineIdById(pharmacyId);
		List<MedicineDTO> medicineDTOS = new ArrayList<>();
		for(Medicine med : medicineList){
			System.out.println("Medicine info: " + med.getName() + " " + med.getId());
			medicineDTOS.add(new MedicineDTO(med));
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
	
	@GetMapping(value = "/healthyAlternativeMedicineForPatient/{id}")
	public ResponseEntity<List<MedicineDTO>> getHealthyAlternativeMedicineForPatient(@PathVariable Long id) {

		List<Medicine> healthyMedicines = new ArrayList<Medicine>();
		
		for(Medicine m: medicineService.findAll()) {
        	if(m.getAlternativeMedicine() != null) {
        		for(Medicine am : m.getAlternativeMedicine()) {
        				healthyMedicines.add(am);
        		}
        	}	
        }

        for(Medicine m: medicineService.findAll()) {
        	if(m.getAlternativeMedicine() != null) {
        		for(Medicine am : m.getAlternativeMedicine()) {
			        for(Allergy a: allergyService.findAll()) {
			        	if(am.getIngredients().contains(a.getMedicineIngredient())
			        	& patientService.findOne(id).getAllergies().contains(a)) {
			        		healthyMedicines.remove(am);
			        	}
			        }
        		}
        	}
        }

		List<MedicineDTO> medicinesDTO = new ArrayList<>();
		for(Medicine m : healthyMedicines){
			//System.out.println(m.getAlternativeMedicine());
			medicinesDTO.add(new MedicineDTO(m));
		}
		return new ResponseEntity<>(medicinesDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<MedicineDTO>> getAll(){
		List<MedicineDTO> medicineDTOS = new ArrayList<>();
		for(Medicine m : medicineService.findAll()){
			medicineDTOS.add(new MedicineDTO(m));
		}
		return new ResponseEntity<>(medicineDTOS,HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<MedicineToAddDTO> addMedicine(@RequestBody MedicineToAddDTO medicineToAddDTO){
		medicineService.save(medicineToAddDTO);
		return new ResponseEntity<>(medicineToAddDTO,HttpStatus.CREATED);
	}
}