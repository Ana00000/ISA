package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AppointmentStatus;

public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Integer> {

}
