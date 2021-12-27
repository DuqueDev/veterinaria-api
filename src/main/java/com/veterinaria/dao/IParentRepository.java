package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.model.Parent;

@Repository
public interface IParentRepository extends JpaRepository<Parent, Long>{
}
