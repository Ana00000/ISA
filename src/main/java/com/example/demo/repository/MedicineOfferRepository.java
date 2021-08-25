package com.example.demo.repository;

import com.example.demo.model.MedicineOffer;
import com.example.demo.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineOfferRepository extends JpaRepository<MedicineOffer, Long> {

    List<MedicineOffer> findAllByMedicineOrderId(Long medicineOrderId);

    List<MedicineOffer> findAllBySupplierId(Long supplierid);
}
