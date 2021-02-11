package com.example.demo.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyMedicine;

public interface PharmacyService {

    Pharmacy findOne(Long id);

    List<Pharmacy> findAll();

    List<Pharmacy> findAllByName(String name);

    List<Pharmacy> findAllByCountry(String country);

    List<Pharmacy> findAllByCity(String city);

    void save(Pharmacy pharmacy);

    void update(Pharmacy pharmacy);

    void remove(Long id);

    void findByFreePharmacists(Time startTime, Time endTime, Date date);

    List<Pharmacy> findAllPharmaciesByDermatologist(Long dermatologistId);
}
