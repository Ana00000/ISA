package com.example.demo.model;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.MedicineOrderDTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;
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

    @Column(name="deadline", unique=true, nullable=false)
    private Timestamp deadline;

    public MedicineOrder() {
    }

    public MedicineOrder(Long id, Map<Medicine, Integer> medicineAmount, Timestamp deadline) {
        this.id = id;
        this.medicineAmount = medicineAmount;
        this.deadline = deadline;
    }

    public MedicineOrder(MedicineOrderDTO medicineOrderDTO) {
        this.id = medicineOrderDTO.getId();
        for (Map.Entry<MedicineDTO, Integer> entry: medicineOrderDTO.getMedicineAmount().entrySet()) {
            Medicine med = new Medicine(entry.getKey());
            this.medicineAmount.put(med, entry.getValue());
        }
        this.deadline = medicineOrderDTO.getDeadline();
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

