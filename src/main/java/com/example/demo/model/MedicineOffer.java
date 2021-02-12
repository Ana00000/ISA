package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.junit.Ignore;

import javax.persistence.*;

@Entity
@Ignore
public class MedicineOffer {

    @Id
    @SequenceGenerator(name = "medicineOfferIdSeqGen", sequenceName = "medicineOfferIdSeqGen", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicineOfferIdSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="supplier_id", referencedColumnName = "id")
    @JsonManagedReference //this will be serialized
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="medicine_order_id", referencedColumnName = "id")
    @JsonManagedReference //this will be serialized
    private MedicineOrder medicineOrder;

    @Column(name="cost", unique=false, nullable=false)
    private int cost;

    public MedicineOffer() {
    }

    public MedicineOffer(Long id, Supplier supplier, MedicineOrder medicineOrder, int cost) {
        this.id = id;
        this.supplier = supplier;
        this.medicineOrder = medicineOrder;
        this.cost = cost;
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
