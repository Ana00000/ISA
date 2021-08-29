package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PharmacyMedicine implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Medicine medicine;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

    @Column( nullable = false, unique = false)
    private int quantity;

	@Column( nullable = false, unique = false)
	private double price;

    public PharmacyMedicine(){
    }

    public PharmacyMedicine(Long id, Medicine medicine, Pharmacy pharmacy, int quantity) {
		super();
    	this.id = id;
        this.medicine = medicine;
        this.pharmacy = pharmacy;
        this.quantity = quantity;
    }

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
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
		PharmacyMedicine other = (PharmacyMedicine) obj;
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

	@Override
	public String toString() {
		return "PharmacyMedicine [id=" + id + ", medicine=" + medicine + ", pharmacy=" + pharmacy + ", quantity="
				+ quantity + "]";
	}
}
