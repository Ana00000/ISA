package com.example.demo.repository;

import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineOrder;
import com.example.demo.model.User;
import org.postgresql.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MedicineOrderRepository extends JpaRepository<MedicineOrder, Long> {

    MedicineOrder findFirstById(Long id);

    @Query(value = "SELECT mo FROM MedicineOrder mo JOIN PharmacyAdmin pa ON mo.pharmacyAdminId=pa.id WHERE pa.pharmacy.id=:pharmacyId")
    List<MedicineOrder> findAllByPharmacyId(@Param("pharmacyId") Long pharmacyId);

    @Query(value = "SELECT mo FROM MedicineOrder mo JOIN mo.medicineAmount map WHERE mo.id=:medicineOrderId")
    List<MedicineOrder> findAllMedicineByOfferId(@Param("medicineOrderId") Long medicineOrderId);

    @Query(value = "SELECT map FROM MedicineOrder mo JOIN mo.medicineAmount map WHERE mo.id=:medicineOrderId")
    List<HashMap<Medicine, Integer>> findMedicineAmountById(@Param("medicineOrderId") Long medicineOrderId);



}
