package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.model.Pharmacy;

@Repository

public interface IPharmacyRepository extends JpaRepository<Pharmacy, Long> {

}
