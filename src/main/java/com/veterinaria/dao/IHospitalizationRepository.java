package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.model.Hospitalization;


@Repository
public interface IHospitalizationRepository extends JpaRepository<Hospitalization, Long>{

}