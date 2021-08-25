package com.example.demo.dto;

import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class MedicineOrderDTOSmaller {
    private Long id;
    private Map<String, Integer> medicineAmount = new HashMap<>();
    private Timestamp deadline;
    private Long pharmacyAdminId;

    public MedicineOrderDTOSmaller(MedicineOrder medicineOrder){
        this.id = medicineOrder.getId();
        this.deadline = medicineOrder.getDeadline();
        this.pharmacyAdminId = medicineOrder.getPharmacyAdminId();

        Map<String, Integer> medicineAmountDTO = new HashMap<>();
        for(Medicine m : medicineOrder.getMedicineAmount().keySet()){
            String key = m.getName();
            int value = medicineOrder.getMedicineAmount().get(m);
            medicineAmountDTO.put(key, value);
        }
        this.medicineAmount = medicineAmountDTO;
    }

    public MedicineOrderDTOSmaller(){}

    public MedicineOrderDTOSmaller(Long id, Map<String, Integer> medicineAmount, Timestamp deadline, Long pharmacyAdminId) {
        this.id = id;
        this.medicineAmount = medicineAmount;
        this.deadline = deadline;
        this.pharmacyAdminId = pharmacyAdminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, Integer> getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(Map<String, Integer> medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Long getPharmacyAdminId() {
        return pharmacyAdminId;
    }

    public void setPharmacyAdminId(Long pharmacyAdminId) {
        this.pharmacyAdminId = pharmacyAdminId;
    }
}
