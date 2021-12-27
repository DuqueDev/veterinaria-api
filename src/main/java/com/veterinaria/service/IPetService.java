package com.veterinaria.service;

import java.util.List;

import com.veterinaria.domain.PetDTO;


public interface IPetService {

	PetDTO save(PetDTO pet);

	List<PetDTO> getAll();

	List<PetDTO> delete(Long id);

	PetDTO update(Long id, PetDTO pet);

}

