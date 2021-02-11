package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Medicine;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.PharmacyMedicine;

public interface PharmacyMedicineRepository extends JpaRepository<PharmacyMedicine, Long> {
	
    PharmacyMedicine findByMedicineAndPharmacy(Medicine medicine, Pharmacy pharmacy);
    
    @Query(value="SELECT pm FROM PharmacyMedicine pm JOIN pm.medicine med WHERE med.id=:medicineId")
    
    PharmacyMedicine findByMedicineId(@Param("medicineId") Long medicineId);
}
