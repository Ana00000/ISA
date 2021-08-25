package com.example.demo.model;

import com.example.demo.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.junit.Ignore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Supplier extends User {

    @ElementCollection
    @CollectionTable(name = "medicine_order_mapping_supplier", joinColumns = @JoinColumn(name = "supplier_id"))
    @MapKeyJoinColumn(name = "medicine_id", referencedColumnName = "id")
    @Column(name = "medicine_order_amount")
    private Map<Medicine, Integer> medicineAmount = new HashMap<>();

    public Supplier() {
    }

    public Supplier(UserDTO userDTO) {
        super(userDTO);
    }

    public Supplier(Long id, String name, String lastName, String email, String password, String address, String phoneNumber, boolean active, String hashString) {
        super(id, name, lastName, email, password, address, phoneNumber, active, hashString);
    }

    public Map<Medicine, Integer> getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(Map<Medicine, Integer> medicineAmount) {
        this.medicineAmount = medicineAmount;
    }
}
