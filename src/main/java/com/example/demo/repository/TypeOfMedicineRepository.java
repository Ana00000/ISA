package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TypeOfMedicine;

public interface TypeOfMedicineRepository extends JpaRepository<TypeOfMedicine, Integer> {

}
