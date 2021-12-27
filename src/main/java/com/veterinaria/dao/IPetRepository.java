package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.veterinaria.model.Pet;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long> {

}
