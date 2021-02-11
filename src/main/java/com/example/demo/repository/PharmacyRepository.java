package com.example.demo.repository;

import com.example.demo.model.Medicine;
import java.util.List;

import com.example.demo.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    List<Pharmacy> findAllByName(String name);

    List<Pharmacy> findAllByCountry(String country);

    List<Pharmacy> findAllByCity(String city);

    @Query(value="SELECT med FROM Pharmacy p JOIN p.medicines med WHERE p.id=:pharmacyId")
    List<Medicine> findMedicineAllById(@Param("pharmacyId") Long Id);

    @Query(value="SELECT p FROM Pharmacy p JOIN p.dermatologists der WHERE der.id=:dermatologistId")
    List<Pharmacy> findAllPharmaciesByDermatologist(@Param("dermatologistId") Long dermatologistId);
}
