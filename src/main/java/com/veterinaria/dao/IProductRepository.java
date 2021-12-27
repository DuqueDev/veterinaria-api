package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
