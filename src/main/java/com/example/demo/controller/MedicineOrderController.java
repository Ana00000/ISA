package com.example.demo.controller;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.MedicineOrderDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.Patient;
import com.example.demo.service.MedicineOrderService;
import com.example.demo.service.impl.MedicineOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/medicineOrder", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineOrderController {

    private final MedicineOrderService medicineOrderService;

    @Autowired
    public MedicineOrderController(MedicineOrderService medicineOrderService) {
        this.medicineOrderService = medicineOrderService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<MedicineOrderDTO>> getAllOrders() {
        System.out.println("------- Get all Orders -------");

        List<MedicineOrder> medicineOrders = medicineOrderService.findAll();

        List<MedicineOrderDTO> medicineOrderDTOs = new ArrayList<>();
        for (MedicineOrder mo : medicineOrders) {
            medicineOrderDTOs.add(new MedicineOrderDTO(mo));
        }

        return new ResponseEntity<>(medicineOrderDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicineOrderDTO> getOrderById(@PathVariable Long id) {
        System.out.println("------- Get Order by " + id + " -------");

        MedicineOrderDTO medicineOrderDTO = new MedicineOrderDTO(medicineOrderService.findOne(id));

        return new ResponseEntity<>(medicineOrderDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/saveOrder")
    public ResponseEntity<MedicineOrderDTO> saveOrder(@RequestBody MedicineOrderDTO medicineOrderDTO) {
        System.out.println("------- Save New Order -------");

        System.out.println(medicineOrderDTO.toString());

        HashMap<MedicineDTO, Integer> medicineAmount = new HashMap<>();
        for (int i = 0; i < medicineOrderDTO.getKeys().size(); ++i) {
            MedicineDTO key = medicineOrderDTO.getKeys().get(i);
            Integer value = medicineOrderDTO.getValues().get(i);

            medicineAmount.put(key, value);
        }

        medicineOrderDTO.setMedicineAmount(medicineAmount);

        MedicineOrder medicineOrder = new MedicineOrder(medicineOrderDTO);

        medicineOrderService.save(medicineOrder);

        return new ResponseEntity<>(medicineOrderDTO, HttpStatus.OK);
    }
}
