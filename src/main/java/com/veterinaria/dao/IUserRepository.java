package com.veterinaria.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	
  public Optional<User> findByUserName(String userName);
  
  public boolean existsByEmail(String email);
  
  public boolean existsByUserName(String userName);
  
  public List<User> findAll();
}
