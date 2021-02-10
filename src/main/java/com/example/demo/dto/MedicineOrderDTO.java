package com.example.demo.dto;

import com.example.demo.model.Medicine;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class MedicineOrderDTO implements Serializable {

    private Long id;

    private Map<Medicine, Integer> medicineAmount = new HashMap<>();

    private Timestamp deadline;

    public MedicineOrderDTO() {
    }

    public MedicineOrderDTO(Long id, Map<Medicine, Integer> medicineAmount, Timestamp deadline) {
        this.id = id;
        this.medicineAmount = medicineAmount;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Medicine, Integer> getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(Map<Medicine, Integer> medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }
}
