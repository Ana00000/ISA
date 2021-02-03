package com.example.demo.model;

import org.junit.Ignore;
import org.springframework.context.annotation.Primary;
import javax.persistence.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pharmacy {

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "pharmacistInPharmacy",
            joinColumns = @JoinColumn(name = "PharmacyId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacistId", referencedColumnName = "id"))
    private Set<Pharmacist> pharmacists;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "MedicineInPharmacy",
            joinColumns = @JoinColumn(name = "PharmacyId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicineId", referencedColumnName = "id"))
    private Set<Medicine> medicines;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "AppointmentInPharmacy",
            joinColumns = @JoinColumn(name = "PharmacyId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointmentId", referencedColumnName = "id"))
    private Set<Appointment> appointments;

    public Pharmacy() {
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
        return super.hashCode();
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
