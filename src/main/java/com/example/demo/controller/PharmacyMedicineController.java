package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PharmacyMedicineDTO;
import com.example.demo.model.PharmacyAdmin;
import com.example.demo.model.PharmacyMedicine;
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

	@Autowired
    public PharmacyMedicineController(PharmacyMedicineService pharmacyMedicineService, EmailServiceImpl emailService,
    		PharmacyAdminService pharmacyAdminService) {
        this.pharmacyMedicineService = pharmacyMedicineService;
        this.emailService = emailService;
        this.pharmacyAdminService = pharmacyAdminService;
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
}