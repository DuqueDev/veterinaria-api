package com.veterinaria.service;

import java.util.List;

import com.veterinaria.domain.ParentDTO;

public interface IParentService {
	
	ParentDTO save(ParentDTO parent);

	List<ParentDTO> getAll();

	List<ParentDTO> delete(Long id);

	ParentDTO update(Long id, ParentDTO parent);

}