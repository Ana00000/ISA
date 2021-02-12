package com.example.demo.model;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.MedicineOrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class MedicineOrder {

    @Id
    @SequenceGenerator(name = "orderIdSeqGen", sequenceName = "orderIdSeqGen", initialValue = 5, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderIdSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "medicine_order_mapping", joinColumns = @JoinColumn(name = "order_id"))
    @MapKeyJoinColumn(name = "medicine_id", referencedColumnName = "id")
    @Column(name = "medicine_order_amount")
    private Map<Medicine, Integer> medicineAmount = new HashMap<>();

    @Column(name="deadline", unique=false, nullable=false)
    private Timestamp deadline;

    @Column(name="pharmacyAdminId", unique=false, nullable=false)
    private Long pharmacyAdminId;

    public MedicineOrder() {
    }

    public MedicineOrder(Long id, Map<Medicine, Integer> medicineAmount, Timestamp deadline, Long pharmacyAdminId) {
        this.id = id;
        this.medicineAmount = medicineAmount;
        this.deadline = deadline;
        this.pharmacyAdminId = pharmacyAdminId;
    }

    public MedicineOrder(MedicineOrderDTO medicineOrderDTO) {
        this.id = medicineOrderDTO.getId();
        for (Map.Entry<MedicineDTO, Integer> entry: medicineOrderDTO.getMedicineAmount().entrySet()) {
            Medicine med = new Medicine(entry.getKey());
            this.medicineAmount.put(med, entry.getValue());
        }
        this.deadline = medicineOrderDTO.getDeadline();
        this.pharmacyAdminId = medicineOrderDTO.getPharmacyAdminId();
    }

    public Long getPharmacyAdminId() {
        return pharmacyAdminId;
    }

    public void setPharmacyAdminId(Long pharmacyAdminId) {
        this.pharmacyAdminId = pharmacyAdminId;
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

    @Override
    public String toString() {
        return "MedicineOrder{" +
                "id=" + id +
                ", medicineAmount=" + medicineAmount +
                ", deadline=" + deadline +
                ", pharmacyAdminId=" + pharmacyAdminId +
                '}';
    }
}

