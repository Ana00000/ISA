package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.example.demo.model.Appointment;
import com.example.demo.model.Dermatologist;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacist;
import com.example.demo.model.Pharmacy;

public class PharmacyDTO implements Serializable {

    public PharmacyDTO() {}

    public PharmacyDTO(Long id, String name, String contact, String country, String city, String street, int number, float longitude, float latitude, float averageGrade, Set<Dermatologist> dermatologists, List<PharmacistDTO> pharmacists, List<MedicineDTO> medicines, List<AppointmentDTO> appointments) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.longitude = longitude;
        this.latitude = latitude;
        this.averageGrade = averageGrade;
        this.dermatologists = dermatologists;
        this.pharmacists = pharmacists;
        this.medicines = medicines;
        this.appointments = appointments;
    }

    public PharmacyDTO(Pharmacy pharmacy) {
        this.id = pharmacy.getId();
        this.name = pharmacy.getName();
        this.contact = pharmacy.getContact();
        this.country = pharmacy.getCountry();
        this.city = pharmacy.getCity();
        this.street = pharmacy.getStreet();
        this.number = pharmacy.getNumber();
        this.longitude = pharmacy.getLongitude();
        this.latitude = pharmacy.getLatitude();
        this.averageGrade = pharmacy.getAverageGrade();
        this.dermatologists = pharmacy.getDermatologists();
        
        List<PharmacistDTO> pharmacists = new ArrayList<PharmacistDTO>();
        for(Pharmacist p: pharmacy.getPharmacists())
        	pharmacists.add(new PharmacistDTO(p));
        this.pharmacists = pharmacists;
        
        List<MedicineDTO> medicines = new ArrayList<MedicineDTO>();
        for(Medicine m: pharmacy.getMedicines())
        	medicines.add(new MedicineDTO(m));
        this.medicines = medicines;
        
        List<AppointmentDTO> appointments = new ArrayList<AppointmentDTO>();
        for(Appointment a: pharmacy.getAppointments())
        	appointments.add(new AppointmentDTO(a));
        this.appointments = appointments;
    }

	private Long id;

    private String name;

    private String contact;

    private String country;

    private String city;

    private String street;

    private int number;

    private float longitude;

    private float latitude;

    private float averageGrade;

    private Set<Dermatologist> dermatologists;

    private List<PharmacistDTO> pharmacists;

    private List<MedicineDTO> medicines; 

    private List<AppointmentDTO> appointments; 

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public Set<Dermatologist> getDermatologists() {
        return dermatologists;
    }

    public void setDermatologists(Set<Dermatologist> dermatologists) {
        this.dermatologists = dermatologists;
    }

    public List<PharmacistDTO> getPharmacists() {
        return pharmacists;
    }

    public void setPharmacists(List<PharmacistDTO> pharmacists) {
        this.pharmacists = pharmacists;
    }

	public List<MedicineDTO> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<MedicineDTO> medicines) {
		this.medicines = medicines;
	}

	public List<AppointmentDTO> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentDTO> appointments) {
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
		PharmacyDTO other = (PharmacyDTO) obj;
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
}
