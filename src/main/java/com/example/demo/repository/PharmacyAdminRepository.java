package com.example.demo.repository;

import com.example.demo.model.PharmacyAdmin;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PharmacyAdminRepository extends JpaRepository<PharmacyAdmin, Long> {

    PharmacyAdmin findOneByPassword(String password);

    List<PharmacyAdmin> findAllByName(String name);

    List<PharmacyAdmin> findAllByLastName(String lastName);

    PharmacyAdmin findByEmail(String email);
}
