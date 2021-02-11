package com.example.demo.repository;

import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineOrderRepository extends JpaRepository<MedicineOrder, Long> {

    MedicineOrder findFirstById(Long id);

}
