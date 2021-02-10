package com.example.demo.dto.Hadzi;

import com.example.demo.model.Pharmacy;

public class PharmacyDTOHadzi {
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

    public PharmacyDTOHadzi(){

    }

    public PharmacyDTOHadzi(Pharmacy pharmacy){
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
}
