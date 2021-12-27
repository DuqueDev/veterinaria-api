package com.veterinaria.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.model.Role;
import com.veterinaria.model.Roles;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRoleName(Roles role);

}
