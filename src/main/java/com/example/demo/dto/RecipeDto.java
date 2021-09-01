package com.example.demo.dto;

import com.example.demo.model.Medicine;
import com.example.demo.model.Patient;
import com.example.demo.model.Recipe;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class RecipeDto {
    private Long id;
    private Map<String, Integer> medicineAmount = new HashMap<>();
    private PatientDTO patient;
    private Timestamp dateOfIssue;

    public RecipeDto(){}

    public RecipeDto(Recipe recipe){
        this.id = recipe.getId();
        this.patient = new PatientDTO(recipe.getPatient());
        this.dateOfIssue = recipe.getDateOfIssue();

        Map<String, Integer> medcineAmountDto = new HashMap<>();

        for(Medicine m :recipe.getMedicineAmount().keySet()){
            String key = m.getName();
            int value = recipe.getMedicineAmount().get(m);
            medcineAmountDto.put(key, value);
        }
        this.medicineAmount = medcineAmountDto;
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

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public Timestamp getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Timestamp dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
}
