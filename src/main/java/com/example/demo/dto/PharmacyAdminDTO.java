package com.example.demo.dto;

import com.example.demo.model.PharmacyAdmin;
import com.example.demo.model.User;

public class PharmacyAdminDTO extends UserDTO{

    private Long pharmacyId;

    public PharmacyAdminDTO() {
        super();
    }

    public PharmacyAdminDTO(User user) {
        super(user);
    }

    public PharmacyAdminDTO(PharmacyAdmin pharmacyAdmin) {
        super(pharmacyAdmin);
        this.pharmacyId = pharmacyAdmin.getPharmacy().getId();
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
}
