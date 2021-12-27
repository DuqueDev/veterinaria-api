package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.model.Doctor;

@Repository

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

}
