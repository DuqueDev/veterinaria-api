package com.veterinaria.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IParentRepository;
import com.veterinaria.domain.ParentDTO;
import com.veterinaria.domain.PetDTO;
import com.veterinaria.exception.ApiError;
import com.veterinaria.model.Hospitalization;
import com.veterinaria.model.Parent;
import com.veterinaria.model.Pet;
import com.veterinaria.model.mapstruct.HospitalizationMapper;
import com.veterinaria.model.mapstruct.ParentMapper;
import com.veterinaria.service.IParentService;
import com.veterinaria.util.VetValidator;

@Service
public class ParentService implements IParentService {
	@Autowired
	private ParentMapper mapper;

	@Autowired
	private IParentRepository repository;
	
	
	//save

	@Override
	public ParentDTO save(ParentDTO dto) {

		if (VetValidator.isGreater(dto.getNombre(), 156)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre supera los 156 caracteres");
		}
		if (VetValidator.isMinor(dto.getNombre(), 1)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre no puede tener menos de 1 caracter");
		}
		if (!VetValidator.isAlpha(dto.getNombre())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre debe contener solo letras");
		}
		
		if (!VetValidator.isAlpha(dto.getTelefono())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el telefono debe contener solo numeros");
		}
		
		
		if (VetValidator.isGreater(dto.getTelefono(), 20)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el telefono supera los 20 caracteres");
		}
		
		if (VetValidator.isMinor(dto.getTelefono(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el telefono no puede tener menos de 3 caracteres");
		}
		
		
		dto.setNombre(VetValidator.toCapitalize(dto.getNombre()));

		Parent entity = mapper.toEntity(dto, new Parent());
		repository.save(entity);
		entity = repository.getById(entity.getId());
		mapper.toDTO(entity, dto);

		return dto;
	}

	@Override
	public List<ParentDTO> getAll() {
		List<Parent> listEntity = repository.findAll();
		return mapper.toDTO(listEntity, new ArrayList<>());
	}

	
	@Override
	public List<ParentDTO> delete(Long id) {
		repository.deleteById(id);
		return getAll();
	}

	@Override
	public ParentDTO update(Long id, ParentDTO parent) {
		repository.findById(id).orElseThrow();
		parent.setId(id);

		Optional<Parent> validationEntity = repository.findById(id);

		if (!validationEntity.isPresent()) {
			throw new ApiError(HttpStatus.BAD_REQUEST,
					"El id " + id + " no existe en la base de datos, verifique e intente de nuevo");
		}

		if (VetValidator.isGreater(parent.getNombre(), 156)) {

		}
		if (VetValidator.isMinor(parent.getNombre(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre no puede tener menos de 3 caracteres");
		}
		if (!VetValidator.isAlpha(parent.getNombre())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre debe contener solo letras");
		}

		parent.setNombre(VetValidator.toCapitalize(parent.getNombre()));

		Parent entity = new Parent();
		entity.setId(id);
		entity.setNombre(parent.getNombre());
		repository.save(entity);
		entity = repository.getById(entity.getId());

		// Lleno mi DTO respuesta con los datos que debo responder
		parent.setId(entity.getId());
		parent.setNombre(entity.getNombre());
		return parent;

	}

}
