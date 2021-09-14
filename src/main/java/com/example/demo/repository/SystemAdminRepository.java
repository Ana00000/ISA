package com.example.demo.repository;

import com.example.demo.model.Supplier;
import com.example.demo.model.SystemAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemAdminRepository extends JpaRepository<SystemAdmin, Long> {
    SystemAdmin findOneByPassword(String password);

    SystemAdmin findOneById(Long id);

    Page<SystemAdmin> findAll(Pageable pageable);

    List<SystemAdmin> findAllByName(String name);

    List<SystemAdmin> findAllByLastName(String lastName);

    List<SystemAdmin> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

    SystemAdmin findByEmail(String email);

    SystemAdmin findByEmailAndPassword(String email, String password);
}
