package com.example.demo.controller;

import com.example.demo.dto.SupplierDTO;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.Supplier;
import com.example.demo.model.SystemAdmin;
import com.example.demo.service.MedicineOrderService;
import com.example.demo.service.SupplierService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/supplier", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierController {

    private SupplierService supplierService;
    private UserService userService;
    private MedicineOrderService medicineOrderService;

    @Autowired
    public SupplierController(SupplierService supplierService, UserService userService, MedicineOrderService medicineOrderService){
        this.supplierService =supplierService;
        this.userService = userService;
        this.medicineOrderService = medicineOrderService;
    }

    @PostMapping(value = "/addSupplier")
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier = new Supplier(supplierDTO);
        supplier.setActive(true);
        userService.save(supplier);
        return new ResponseEntity<>(supplierDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/doIHaveMedicineForOrder/{orderId}")
    public ResponseEntity<Boolean> doIHaveMedicineForOrder(Authentication authentication, @PathVariable Long orderId){
        MedicineOrder medicineOrder = medicineOrderService.findOne(orderId);
        Supplier supplier = supplierService.findByEmail(authentication.getName());

        for(Medicine m : medicineOrder.getMedicineAmount().keySet()){
            if(medicineOrder.getMedicineAmount().get(m) > supplier.getMedicineAmount().get(m)){
                return new ResponseEntity<>(false,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @GetMapping(value = "/getSupplier")
    public ResponseEntity<SupplierDTO> getSupplier(Authentication authentication){
        Supplier supplier = supplierService.findByEmail(authentication.getName());
        SupplierDTO supplierDTO = new SupplierDTO(supplier);
        return new ResponseEntity<>(supplierDTO,HttpStatus.OK);
    }

    @PostMapping(value = "/editSupplier")
    public ResponseEntity<SupplierDTO> editSupplier(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier = supplierService.findByEmail(supplierDTO.getEmail());
        if(supplier == null){
            new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        supplier.setName(supplierDTO.getName());
        supplier.setLastName(supplierDTO.getLastName());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());

        userService.save(supplier);
        return new ResponseEntity<>(supplierDTO,HttpStatus.OK);
    }

    @PostMapping(value = "/editPassword/{newPassword}")
    public ResponseEntity<SupplierDTO> edit(Authentication authentication, @PathVariable String newPassword){
        Supplier supplier = supplierService.findByEmail(authentication.getName());
        supplier.setPassword(newPassword);
        supplier.setLoggedFirstTime(false);
        userService.save(supplier);
        return new ResponseEntity<>(new SupplierDTO(supplier),HttpStatus.OK);
    }
}
