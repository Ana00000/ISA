package com.example.demo.service;

import com.example.demo.model.Pharmacist;
import com.example.demo.model.Pharmacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

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
