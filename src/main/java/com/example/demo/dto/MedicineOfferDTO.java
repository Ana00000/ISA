package com.example.demo.dto;

import com.example.demo.model.MedicineOffer;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.PharmacyAdmin;
import com.example.demo.model.Supplier;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

public class MedicineOfferDTO implements Serializable {

    private Long id;

    private SupplierDTO supplier;

    private MedicineOrderDTO medicineOrder;

    private int cost;

    private PharmacyAdminDTO pharmacyAdmin;

    public MedicineOfferDTO() {
    }

    public MedicineOfferDTO(MedicineOffer medicineOffer) {
        this.id = medicineOffer.getId();
        this.cost = medicineOffer.getCost();
        this.medicineOrder = new MedicineOrderDTO(medicineOffer.getMedicineOrder());
        this.supplier = new SupplierDTO(medicineOffer.getSupplier());
    }

    public MedicineOfferDTO(Long id, SupplierDTO supplier, MedicineOrderDTO medicineOrder, int cost, PharmacyAdminDTO pharmacyAdmin) {
        this.id = id;
        this.supplier = supplier;
        this.medicineOrder = medicineOrder;
        this.cost = cost;
        this.pharmacyAdmin = pharmacyAdmin;
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
