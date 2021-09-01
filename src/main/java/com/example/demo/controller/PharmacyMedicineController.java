package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.service.PharmacyService;
import com.example.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.PharmacyAdminService;
import com.example.demo.service.PharmacyMedicineService;
import com.example.demo.service.email.EmailServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/pharmacyMedicines", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyMedicineController {

    private final PharmacyMedicineService pharmacyMedicineService;
    private final EmailServiceImpl emailService;
    private final PharmacyAdminService pharmacyAdminService;
    private final PharmacyService pharmacyService;
    private final RecipeService recipeService;

	@Autowired
    public PharmacyMedicineController(PharmacyMedicineService pharmacyMedicineService, EmailServiceImpl emailService,
									  PharmacyAdminService pharmacyAdminService, PharmacyService pharmacyService, RecipeService recipeService) {
        this.pharmacyMedicineService = pharmacyMedicineService;
        this.emailService = emailService;
        this.pharmacyAdminService = pharmacyAdminService;
		this.pharmacyService = pharmacyService;
		this.recipeService = recipeService;
	}
	
	@GetMapping(value = "/all")
    public ResponseEntity<List<PharmacyMedicineDTO>> getAllPharmacyMedicines() {

        List<PharmacyMedicine> pharmacyMedicines = pharmacyMedicineService.findAll();

		List<PharmacyMedicineDTO> pharmacyMedicineDTO = new ArrayList<>();
		for (PharmacyMedicine pm : pharmacyMedicines) {
			pharmacyMedicineDTO.add(new PharmacyMedicineDTO(pm));
		}

		return new ResponseEntity<>(pharmacyMedicineDTO, HttpStatus.OK);
    }

    @GetMapping("/getPharmacyMedicine")
	public ResponseEntity<PharmacyMedicineDTO> getPrice(@RequestParam Long medicineId, @RequestParam Long pharmacyId){
		PharmacyMedicine pharmacyMedicine = pharmacyMedicineService.findByPharmacyIdAndMedicineId(pharmacyId,medicineId);
		if(pharmacyMedicine == null){
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new PharmacyMedicineDTO(pharmacyMedicine),HttpStatus.OK);
	}


	@GetMapping(value = "/getPharmacyMedicine/{id}")
	public ResponseEntity<PharmacyMedicineDTO> getPharmacyMedicine(@PathVariable Long id) {

		PharmacyMedicine pharmacyMedicine = pharmacyMedicineService.findOne(id);

		if (pharmacyMedicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new PharmacyMedicineDTO(pharmacyMedicine), HttpStatus.OK);
	}
	
	@GetMapping(value = "/findPharmacyMedicineByMedicine/{id}")
    public ResponseEntity<PharmacyMedicineDTO> getPharmacyMedicineByMedicine(@PathVariable Long id) {

    	PharmacyMedicine pharmacyMedicine = pharmacyMedicineService.findByMedicineId(id);
        
		if (pharmacyMedicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new PharmacyMedicineDTO(pharmacyMedicine), HttpStatus.OK);
	}

	@GetMapping(value = "/sendMedicineNotification/{id}")
    public ResponseEntity<Void> sendMedicineNotification(@PathVariable Long id) {

    	PharmacyMedicine pharmacyMedicine = pharmacyMedicineService.findOne(id);

		for(PharmacyAdmin pa : pharmacyAdminService.findAll()) {
			if(pharmacyMedicine.getPharmacy().getId() == pa.getPharmacy().getId()) {
				emailService.sendEmail(pa.getEmail(),"Greetings, there are no more medicine "
						+pharmacyMedicine.getMedicine().getName()+" in pharmacy "+
						pharmacyMedicine.getPharmacy().getName()+". Regards, Hospital IsaIBisa",
					"Medicine need");
			}
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value="/update")
	public ResponseEntity<PharmacyMedicineDTO> updatePharmacyMedicine(@RequestBody PharmacyMedicineDTO pharmacyMedicineDTO) {

		PharmacyMedicine pharmacyMedicine = pharmacyMedicineService.findOne(pharmacyMedicineDTO.getId());

		if (pharmacyMedicine == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		pharmacyMedicine.setId(pharmacyMedicineDTO.getId());
		pharmacyMedicine.setQuantity(pharmacyMedicineDTO.getQuantity()-1);

		pharmacyMedicine = pharmacyMedicineService.save(pharmacyMedicine);
		return new ResponseEntity<>(new PharmacyMedicineDTO(pharmacyMedicine), HttpStatus.OK);
	}

	@GetMapping(value = "/findMedicineByPharmacyId={id}")
	public ResponseEntity<List<MedicineDTO>> getMedicineByPharmacyId(@PathVariable Long id) {

		List<Medicine> pharmacyMedicine = pharmacyMedicineService.findMedicineByPharmacyId(id);

		List<MedicineDTO> pharmacyMedicineDTOS = new ArrayList<>();
		for (Medicine med : pharmacyMedicine) {
			MedicineDTO medicineDTO = new MedicineDTO(med);
			pharmacyMedicineDTOS.add(medicineDTO);
		}

		return new ResponseEntity<>(pharmacyMedicineDTOS, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllPharmaciesForRecipe/{recipeId}")
	public ResponseEntity<List<PharmacyDTO>> getAllPharmaciesThatContainMedicinesFromRecipe(@PathVariable Long recipeId){
		Recipe recipe = recipeService.findOne(recipeId);
		List<PharmacyDTO> retList = new ArrayList<>();
		boolean containAllMedicine = true;
		for(Pharmacy pharmacy : pharmacyService.findAll()){//prodji kroz sve apoteke
			containAllMedicine = isPharmacyContainingAllMedicine(recipe, pharmacy);
			if(containAllMedicine){
				retList.add(new PharmacyDTO(pharmacy));
			}
		}
		return new ResponseEntity<>(retList,HttpStatus.OK);
	}

	private boolean isPharmacyContainingAllMedicine(Recipe recipe, Pharmacy pharmacy) {
		boolean containAllMedicine;
		containAllMedicine = true;
		List<PharmacyMedicine> pharmacyMedicines = pharmacyMedicineService.findAllByPharmacyId(pharmacy.getId());

		boolean pharmacyContainMedicine = false;
		for(Medicine medic: recipe.getMedicineAmount().keySet()){	//prodji kroz sve lekove iz recepta
			pharmacyContainMedicine = isPharmacyContainingMedicine(recipe, pharmacyMedicines, medic);
			if(pharmacyContainMedicine == false){
				containAllMedicine = false;
				break ;
			}
		}
		return containAllMedicine;
	}

	private boolean isPharmacyContainingMedicine(Recipe recipe, List<PharmacyMedicine> pharmacyMedicines, Medicine medic) {
		boolean pharmacyContainMedicine;
		pharmacyContainMedicine= false;
		for(PharmacyMedicine pm : pharmacyMedicines){		//prodji kroz lekove iz apoteke
			if(isItSameMedicine(pm.getMedicine(), medic)){
				int recipeAmountNeeded = recipe.getMedicineAmount().get(medic);
				int pharmacyHave = pm.getQuantity();
				if(recipeAmountNeeded <= pharmacyHave){
					pharmacyContainMedicine = true;
					break ;
				}
			}
		}
		return pharmacyContainMedicine;
	}

	@GetMapping(value = "/getPriceForSelectedPharmacyAndRecipe/{recipeId}/{pharmacyId}")
	public ResponseEntity<Integer> getPriceForSelectedPharmacyAndRecipe(@PathVariable Long recipeId,@PathVariable Long pharmacyId){
		int price = 0;
		Recipe recipe = recipeService.findOne(recipeId);
		List<PharmacyMedicine> pharmacyMedicines = pharmacyMedicineService.findAllByPharmacyId(pharmacyId);



		for(Medicine m : recipe.getMedicineAmount().keySet()){
			for(PharmacyMedicine pm : pharmacyMedicines){
				if(isItSameMedicine(m,pm.getMedicine())){
					int amount =recipe.getMedicineAmount().get(m);
					price+= (pm.getPrice()*amount);
				}
			}
		}
		return new ResponseEntity<>(price,HttpStatus.OK);
	}

	@PostMapping(value = "/buyMedicinesForRecipe")
	public ResponseEntity<String> buyMedicinesForRecipeInChoosenPharmacy(@RequestBody BuyMedicineForRecipeDTO buyMedicineForRecipeDTO){
		Recipe recipe = recipeService.findOne(buyMedicineForRecipeDTO.getRecipeId());
		List<PharmacyMedicine> pharmacyMedicines = pharmacyMedicineService.findAllByPharmacyId(buyMedicineForRecipeDTO.getPharmacyId());
		Pharmacy pharmacy = pharmacyService.findOne(buyMedicineForRecipeDTO.getPharmacyId());
		if(!isPharmacyContainingAllMedicine(recipe,pharmacy)){
			new ResponseEntity<>("Pharmacy don't have all medicine!",HttpStatus.BAD_REQUEST);
		}
		GetAllMedicineFromRecipeForChoosenPharmacy(recipe, pharmacyMedicines);
		recipeService.remove(recipe.getId());
		return new ResponseEntity<>("You have successfully bought all medicine from recipe",HttpStatus.OK);
	}

	private void GetAllMedicineFromRecipeForChoosenPharmacy(Recipe recipe, List<PharmacyMedicine> pharmacyMedicines) {
		for(Medicine m : recipe.getMedicineAmount().keySet()){
			for(PharmacyMedicine pm : pharmacyMedicines){
				if(isItSameMedicine(m, pm.getMedicine())){
					int medicineNeeded = recipe.getMedicineAmount().get(m);
					pm.setQuantity(pm.getQuantity()-medicineNeeded);
					pharmacyMedicineService.save(pm);
				}
			}
		}
	}

	private boolean isItSameMedicine(Medicine m, Medicine medicine) {
		return m.getName().equals(medicine.getName());
	}
}