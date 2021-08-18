package com.example.demo.controller;

import com.example.demo.dto.SupplierDTO;
import com.example.demo.model.Supplier;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/supplier", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierController {
    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService){
        this.supplierService =supplierService;
    }

    @PostMapping(value = "/addSupplier")
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier = new Supplier(supplierDTO);
        supplier.setActive(true);
        supplierService.save(supplier);
        return new ResponseEntity<>(supplierDTO, HttpStatus.CREATED);
    }
}
