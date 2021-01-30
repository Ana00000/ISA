package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AppointmentType;

public interface AppointmentTypeRepository extends JpaRepository<AppointmentType, Integer> {

}
