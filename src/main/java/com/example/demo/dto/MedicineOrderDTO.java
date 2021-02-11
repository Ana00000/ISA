package com.example.demo.dto;

import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

public class MedicineOrderDTO implements Serializable{

    private Long id;

    @JsonIgnore
    private Map<MedicineDTO, Integer> medicineAmount = new HashMap<>();

    private List<MedicineDTO> keys = new ArrayList<>();

    private List<Integer> values = new ArrayList<>();

    private Timestamp deadline;

    public MedicineOrderDTO() {
    }

    public MedicineOrderDTO(Long id, List<MedicineDTO> keys, List<Integer> values, Timestamp deadline) {
        this.id = id;
        this.keys = keys;
        this.values = values;
        this.deadline = deadline;
    }

    public MedicineOrderDTO(MedicineOrder medicineOrder) {
        this.id = medicineOrder.getId();
        //this.medicineAmount = medicineOrder.getMedicineAmount();
        this.deadline = medicineOrder.getDeadline();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<MedicineDTO, Integer> getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(Map<MedicineDTO, Integer> medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public List<MedicineDTO> getKeys() {
        return keys;
    }

    public void setKeys(List<MedicineDTO> keys) {
        this.keys = keys;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "MedicineOrderDTO{" +
                "id=" + id +
                ", medicineAmount=" + medicineAmount +
                ", keys=" + keys +
                ", values=" + values +
                ", deadline=" + deadline +
                '}';
    }
}
