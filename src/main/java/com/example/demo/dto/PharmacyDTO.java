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
}
