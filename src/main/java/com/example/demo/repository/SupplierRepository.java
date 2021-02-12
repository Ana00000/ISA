package com.example.demo.repository;

import com.example.demo.model.Supplier;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Supplier findOneByPassword(String password);

    Supplier findOneById(Long id);

    Page<Supplier> findAll(Pageable pageable);

    List<Supplier> findAllByName(String name);

    List<Supplier> findAllByLastName(String lastName);

    List<Supplier> findByNameAndLastNameAllIgnoringCase(String name, String lastName);

    Supplier findByEmail(String email);

    Supplier findByEmailAndPassword(String email, String password);
}
