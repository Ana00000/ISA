package com.example.demo.dto;

import com.example.demo.model.MedicineOffer;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.PharmacyAdmin;
import com.example.demo.model.Supplier;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

public class MedicineOfferDTO implements Serializable {

    private Long id;

    private SupplierDTO supplier;

    private MedicineOrderDTO medicineOrder;

    private Long medicineOrderId;

    private int cost;

    private Timestamp time;

    private PharmacyAdminDTO pharmacyAdmin;

    private String status;

    public MedicineOfferDTO() {
    }

    public MedicineOfferDTO(MedicineOffer medicineOffer) {
        this.id = medicineOffer.getId();
        this.cost = medicineOffer.getCost();
        this.medicineOrder = new MedicineOrderDTO(medicineOffer.getMedicineOrder());
        this.supplier = new SupplierDTO(medicineOffer.getSupplier());
        this.time = medicineOffer.getTime();
        this.status = medicineOffer.getOfferStatus().getText();
    }

    public MedicineOfferDTO(Long id, SupplierDTO supplier, MedicineOrderDTO medicineOrder, int cost, PharmacyAdminDTO pharmacyAdmin, Timestamp time) {
        this.id = id;
        this.supplier = supplier;
        this.medicineOrder = medicineOrder;
        this.cost = cost;
        this.pharmacyAdmin = pharmacyAdmin;
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMedicineOrderId() {
        return medicineOrderId;
    }

    public void setMedicineOrderId(Long medicineOrderId) {
        this.medicineOrderId = medicineOrderId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SupplierDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDTO supplier) {
        this.supplier = supplier;
    }

    public MedicineOrderDTO getMedicineOrder() {
        return medicineOrder;
    }

    public void setMedicineOrder(MedicineOrderDTO medicineOrder) {
        this.medicineOrder = medicineOrder;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public PharmacyAdminDTO getPharmacyAdmin() {
        return pharmacyAdmin;
    }

    public void setPharmacyAdmin(PharmacyAdminDTO pharmacyAdmin) {
        this.pharmacyAdmin = pharmacyAdmin;
    }

    @Override
    public String toString() {
        return "MedicineOfferDTO{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", medicineOrder=" + medicineOrder +
                ", cost=" + cost +
                ", pharmacyAdmin=" + pharmacyAdmin +
                '}';
    }
}
