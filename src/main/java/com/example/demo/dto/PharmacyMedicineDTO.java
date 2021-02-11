package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.PharmacyMedicine;

public class PharmacyMedicineDTO implements Serializable {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicine == null) ? 0 : medicine.hashCode());
		result = prime * result + ((pharmacy == null) ? 0 : pharmacy.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PharmacyMedicineDTO other = (PharmacyMedicineDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicine == null) {
			if (other.medicine != null)
				return false;
		} else if (!medicine.equals(other.medicine))
			return false;
		if (pharmacy == null) {
			if (other.pharmacy != null)
				return false;
		} else if (!pharmacy.equals(other.pharmacy))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
}
