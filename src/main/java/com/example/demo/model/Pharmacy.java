package com.example.demo.model;

import com.example.demo.dto.PharmacyDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.junit.Ignore;
import org.springframework.context.annotation.Primary;
import javax.persistence.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pharmacy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="name", unique=false, nullable=false)
    private String name;

    @Column(name="contact", unique=false, nullable=false)
    private String contact;

    @Column(name="country", unique=false, nullable=false)
    private String country;

    @Column(name="city", unique=false, nullable=false)
    private String city;

    @Column(name="street", unique=false, nullable=false)
    private String street;

    @Column(name="number", unique=false, nullable=false)
    private int number;

    @Column(name="longitude", unique=false, nullable=false)
    private float longitude;

    @Column(name="latitude", unique=false, nullable=false)
    private float latitude;

    @Column(name="averageGrade", unique=false, nullable=true)
    private float averageGrade;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "dermatologistInPharmacy",
            joinColumns = @JoinColumn(name = "PharmacyId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "DermatologistId", referencedColumnName = "id"))
    private Set<Dermatologist> dermatologists;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pharmacy")
    @JsonBackReference//this will not serialize
    private Set<Pharmacist> pharmacists;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "MedicineInPharmacy",
            joinColumns = @JoinColumn(name = "PharmacyId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicineId", referencedColumnName = "id"))
    private Set<Medicine> medicines = new HashSet<Medicine>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "AppointmentInPharmacy",
            joinColumns = @JoinColumn(name = "PharmacyId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointmentId", referencedColumnName = "id"))
    private Set<Appointment> appointments = new HashSet<Appointment>();

    public Pharmacy() {
    }

    public Pharmacy(PharmacyDTO pharmacyDTO) {
        this.id = pharmacyDTO.getId();
        this.name = pharmacyDTO.getName();
    }

    public Pharmacy(Long id, String name, String country, String city, String street, int number, float longitude, float latitude, float averageGrade) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.longitude = longitude;
        this.latitude = latitude;
        this.averageGrade = averageGrade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public Set<Dermatologist> getDermatologists() {
        return dermatologists;
    }

    public void setDermatologists(Set<Dermatologist> dermatologists) {
        this.dermatologists = dermatologists;
    }

    public Set<Pharmacist> getPharmacists() {
        return pharmacists;
    }

    public void setPharmacists(Set<Pharmacist> pharmacists) {
        this.pharmacists = pharmacists;
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Set<Medicine> medicines) {
        this.medicines = medicines;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointments == null) ? 0 : appointments.hashCode());
		result = prime * result + Float.floatToIntBits(averageGrade);
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dermatologists == null) ? 0 : dermatologists.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + ((medicines == null) ? 0 : medicines.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + ((pharmacists == null) ? 0 : pharmacists.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Pharmacy other = (Pharmacy) obj;
		if (appointments == null) {
			if (other.appointments != null)
				return false;
		} else if (!appointments.equals(other.appointments))
			return false;
		if (Float.floatToIntBits(averageGrade) != Float.floatToIntBits(other.averageGrade))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dermatologists == null) {
			if (other.dermatologists != null)
				return false;
		} else if (!dermatologists.equals(other.dermatologists))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		if (medicines == null) {
			if (other.medicines != null)
				return false;
		} else if (!medicines.equals(other.medicines))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (pharmacists == null) {
			if (other.pharmacists != null)
				return false;
		} else if (!pharmacists.equals(other.pharmacists))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
