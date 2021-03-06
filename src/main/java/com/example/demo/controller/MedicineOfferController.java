package com.example.demo.controller;

import com.example.demo.dto.MedicineOfferDTO;
import com.example.demo.dto.MedicineOrderDTO;
import com.example.demo.model.*;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.*;
import com.example.demo.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/medicineOffers", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineOfferController {

    private final MedicineOrderService medicineOrderService;
    private final MedicineOfferService medicineOfferService;
    private final EmailServiceImpl emailService;
    private final PharmacyMedicineService pharmacyMedicineService;
    private final PharmacyService pharmacyService;
    private final SupplierService supplierService;

    @Autowired
    public MedicineOfferController(MedicineOrderService medicineOrderService,
                                   MedicineOfferService medicineOfferService,
                                   EmailServiceImpl emailService,
                                   PharmacyMedicineService pharmacyMedicineService,
                                   PharmacyService pharmacyService,
                                   SupplierService supplierService) {
        this.medicineOrderService = medicineOrderService;
        this.medicineOfferService = medicineOfferService;
        this.emailService = emailService;
        this.pharmacyMedicineService = pharmacyMedicineService;
        this.pharmacyService = pharmacyService;
        this.supplierService = supplierService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<MedicineOfferDTO>> getAllOffers() {
        System.out.println("------- Get all Offers -------");

        List<MedicineOffer> medicineOffers = medicineOfferService.findAll();

        List<MedicineOfferDTO> medicineOfferDTOs = new ArrayList<>();
        for (MedicineOffer mo : medicineOffers) {
            medicineOfferDTOs.add(new MedicineOfferDTO(mo));
        }

        return new ResponseEntity<>(medicineOfferDTOs, HttpStatus.OK);
    }

    @PostMapping(value = "/chosenOffer")
    public ResponseEntity<MedicineOfferDTO> chosenOffer(@RequestBody List<MedicineOfferDTO> medicineOfferDTOs) {
        System.out.println("------- Chosen offer -------");



        MedicineOfferDTO medicineOfferDTO = medicineOfferDTOs.get(0);
        System.out.println(medicineOfferDTO.toString());

        List<MedicineOffer> deniedMedicineOffers = medicineOfferService.findAllByOrderId(medicineOfferDTO.getMedicineOrder().getId());

        MedicineOffer acceptedMedicineOffer = medicineOfferService.findOne(medicineOfferDTO.getId());

        deniedMedicineOffers.remove(acceptedMedicineOffer);

        System.out.println("=============================================");
        Supplier acceptedSupplier = supplierService.findOne(acceptedMedicineOffer.getSupplier().getId());

        System.out.println("Accepted:" + acceptedSupplier.getEmail());
        String body = " Dear " + acceptedSupplier.getName() + " " + acceptedSupplier.getLastName() + ",\n" +
                "Hereby We want to inform you that your application for our order under number: " + acceptedMedicineOffer.getMedicineOrder().getId() +
                "\n\nhas been ACCEPTED. Thank You for being our partner.\n\n Sincerely Yours,\nIsaIBisa Team";
        String topic = "Your offer has been ACCEPTED!";
        emailService.sendEmail(acceptedSupplier.getEmail(), body, topic);

        for(MedicineOffer medicineOffer : deniedMedicineOffers){
            Supplier deniedSupplier = supplierService.findOne(medicineOffer.getSupplier().getId());
            System.out.println("Denied: " + deniedSupplier.getEmail());
            String body1 = "Dear " + acceptedSupplier.getName() + " " + acceptedSupplier.getLastName() + ",\n" +
                    "Hereby We want to inform you that your application for our order under number: " + acceptedMedicineOffer.getMedicineOrder().getId() +
                    "\n\nhas been DENIED. Thank You for being our partner.\n\n Sincerely Yours,\nIsaIBisa Team";
            String topic1 = "Your offer has been DENIED!";
            emailService.sendEmail(deniedSupplier.getEmail(), body1, topic1);
        }

        MedicineOrder medicineOrder = medicineOrderService.findOne(medicineOfferDTO.getMedicineOrder().getId());

        Map<Medicine, Integer> medicineAmount = medicineOrder.getMedicineAmount();
        System.out.println(medicineOrder);

        System.out.println("---- MAP ITERATION ----");
        for (Map.Entry<Medicine, Integer> entry : medicineAmount.entrySet()) {
            System.out.println(entry.getKey() + "  => " + entry.getValue());
            System.out.println("---- ------------------------- ----");
        }


        for (Map.Entry<Medicine, Integer> entry : medicineAmount.entrySet()) {
            System.out.println("Pharmacy: " + medicineOfferDTO.getPharmacyAdmin().getPharmacyId());
            System.out.println("Medicine: " + entry.getKey().getId());
            PharmacyMedicine updatingPharmacyMedicine = pharmacyMedicineService.findByPharmacyIdAndMedicineId(medicineOfferDTO.getPharmacyAdmin().getPharmacyId(), entry.getKey().getId());
            if (updatingPharmacyMedicine == null) {
                updatingPharmacyMedicine = new PharmacyMedicine();
                updatingPharmacyMedicine.setQuantity(entry.getValue());
                updatingPharmacyMedicine.setMedicine(entry.getKey());
                updatingPharmacyMedicine.setPharmacy(pharmacyService.findOne(medicineOfferDTO.getPharmacyAdmin().getPharmacyId()));
                pharmacyMedicineService.save(updatingPharmacyMedicine);
            }
            else {
                System.out.println(updatingPharmacyMedicine.toString());
                updatingPharmacyMedicine.setQuantity(entry.getValue());
                pharmacyMedicineService.updatePharmacyMedicine(updatingPharmacyMedicine);
            }
        }

        for(MedicineOffer mof : medicineOfferService.findAll()) {
            if (mof.getMedicineOrder().getId().equals(medicineOrder.getId()))
                medicineOfferService.remove(mof.getId());
        }

        System.out.println(medicineOrder.toString());
        try {
            medicineOrderService.remove(medicineOrder.getId());
        }
        catch (Exception e) {
            System.out.println("Medicine Order already deleted!");
        }

        supplierService.save(acceptedSupplier);

        return new ResponseEntity<>(medicineOfferDTO, HttpStatus.OK);
    }
}
