package com.example.demo.dto;

import com.example.demo.model.PharmacyMedicine;

public class PharmacyMedicineDTO {

	private Long id;
    private MedicineDTO medicine;
    private PharmacyDTO pharmacy;
    private int quantity;
    
    public PharmacyMedicineDTO() {}

    public PharmacyMedicineDTO(Long id, MedicineDTO medicine, PharmacyDTO pharmacy, int quantity) {
    	this.id = id;
        this.medicine = medicine;
        this.pharmacy = pharmacy;
        this.quantity = quantity;
    }

    public PharmacyMedicineDTO(PharmacyMedicine pharmacyMedicine) {
        this.id = pharmacyMedicine.getId();
        this.medicine = new MedicineDTO(pharmacyMedicine.getMedicine());
        this.pharmacy = new PharmacyDTO(pharmacyMedicine.getPharmacy());
        this.quantity = pharmacyMedicine.getQuantity();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicineDTO getMedicine() {
		return medicine;
	}

	public void setMedicine(MedicineDTO medicine) {
		this.medicine = medicine;
	}

	public PharmacyDTO getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(PharmacyDTO pharmacy) {
		this.pharmacy = pharmacy;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
