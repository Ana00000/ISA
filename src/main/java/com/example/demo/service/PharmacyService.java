package com.example.demo.service;

import com.example.demo.model.Medicine;
import com.example.demo.model.Patient;
import com.example.demo.model.Pharmacy;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface PharmacyService {

    Pharmacy findOne(Long id);

    List<Pharmacy> findAll();

    List<Pharmacy> findAllByName(String name);

    List<Pharmacy> findAllByCountry(String country);

    List<Pharmacy> findAllByCity(String city);

    List<Medicine> findMedicineIdById(Long pharmacyId);

    void save(Pharmacy pharmacy);

    void update(Pharmacy pharmacy);

    void remove(Long id);

    void findByFreePharmacists(Time startTime, Time endTime, Date date);

    List<Pharmacy> findAllPharmaciesByDermatologist(Long dermatologistId);

    List<Pharmacy> findAllPharmaciesByPatient(Patient patient);
}
