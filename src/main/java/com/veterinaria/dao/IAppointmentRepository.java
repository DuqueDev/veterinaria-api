package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.model.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

}
