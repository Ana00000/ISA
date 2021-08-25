package com.example.demo.model;

import com.example.demo.dto.MedicineOfferDTO;
import com.example.demo.model.enums.OfferStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.junit.Ignore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Ignore
public class MedicineOffer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="supplier_id", referencedColumnName = "id")
    @JsonManagedReference //this will be serialized
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medicine_order_id", referencedColumnName = "id")
    @JsonManagedReference //this will be serialized
    private MedicineOrder medicineOrder;

    @Column(name="cost", unique=false, nullable=false)
    private int cost;

    @Column(name="time", unique=false, nullable=true)
    private Timestamp time;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;

    public MedicineOffer() {
    }

    public MedicineOffer(Long id, Supplier supplier, MedicineOrder medicineOrder, int cost) {
        this.id = id;
        this.supplier = supplier;
        this.medicineOrder = medicineOrder;
        this.cost = cost;
    }

    public MedicineOffer(MedicineOfferDTO medicineOfferDTO){
        this.id = medicineOfferDTO.getId();
        this.supplier = new Supplier(medicineOfferDTO.getSupplier());
        this.medicineOrder = new MedicineOrder(medicineOfferDTO.getMedicineOrder());
        this.cost = medicineOfferDTO.getCost();
        this.offerStatus = OfferStatus.WAITING;
        this.time = medicineOfferDTO.getTime();
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public MedicineOrder getMedicineOrder() {
        return medicineOrder;
    }

    public void setMedicineOrder(MedicineOrder medicineOrder) {
        this.medicineOrder = medicineOrder;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "MedicineOffer{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", medicineOrder=" + medicineOrder +
                ", cost=" + cost +
                '}';
    }
}
