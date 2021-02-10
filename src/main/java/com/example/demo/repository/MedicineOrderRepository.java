package com.example.demo.repository;

import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineOrderRepository extends JpaRepository<MedicineOrder, Long> {


}
