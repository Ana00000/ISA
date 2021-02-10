package com.example.demo.repository;

import com.example.demo.model.Pharmacist;
import com.example.demo.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    List<Pharmacy> findAllByName(String name);

    List<Pharmacy> findAllByCountry(String country);

    List<Pharmacy> findAllByCity(String city);

    List<Pharmacy> findAllByPharmacist(Pharmacist pharmacist);

}
