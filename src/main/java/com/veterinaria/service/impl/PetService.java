package com.veterinaria.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IPetRepository;
import com.veterinaria.domain.DoctorDTO;
import com.veterinaria.domain.ParentDTO;
import com.veterinaria.domain.PetDTO;
import com.veterinaria.exception.ApiError;
import com.veterinaria.model.Doctor;
import com.veterinaria.model.Parent;
import com.veterinaria.model.Pet;
import com.veterinaria.model.mapstruct.PetMapper;
import com.veterinaria.service.IPetService;
import com.veterinaria.util.VetValidator;

/**
 * Service that handle all the repository calls for Pet Entity
 * 
 * @author Oscar
 *
 */

@Service
public class PetService implements IPetService {

	@Autowired
	public PetMapper mapper;

	@Autowired
	private IPetRepository repository;

	@Override
	public PetDTO save(PetDTO dto) {
		if (VetValidator.isGreater(dto.getNombre(), 156)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre supera los 156 caracteres");
		}
		if (VetValidator.isMinor(dto.getNombre(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre no puede tener menos de 3 caracteres");
		}
		if (!VetValidator.isAlpha(dto.getNombre())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre debe contener solo letras");
		}
		if (VetValidator.isGreater(dto.getMotivoIngreso(), 256)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el motivo de ingreso supera los 256 caracteres");
		}
		if (VetValidator.isMinor(dto.getMotivoIngreso(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST,
					"Error el motivo de ingreso no puede tener menos de 3 caracteres");
		}
		dto.setNombre(VetValidator.toCapitalize(dto.getNombre()));

		Pet entity = mapper.toEntity(dto, new Pet());
		repository.save(entity);
		entity = repository.getById(entity.getId());
		mapper.toDTO(entity, dto);
		return dto;

	}

	/**
	 * Method to get all the pets in entity Pet
	 */
	@Override
	public List<PetDTO> getAll() {
		List<Pet> listEntity = repository.findAll();
		return mapper.toDTO(listEntity, new ArrayList<>());

	}

	public List<PetDTO> delete(Long id) {
		repository.deleteById(id);
		return getAll();
	}

	@Override
	public PetDTO update(Long id, PetDTO dto) {

		Optional<Pet> validationEntity = repository.findById(id);

		if (!validationEntity.isPresent()) {
			throw new ApiError(HttpStatus.BAD_REQUEST,
					"El id " + id + " no existe en la base de datos, verifique e intente de nuevo");
		}

		if (VetValidator.isGreater(dto.getNombre(), 156)) {

		}
		if (VetValidator.isMinor(dto.getNombre(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre no puede tener menos de 3 caracteres");
		}
		if (!VetValidator.isAlpha(dto.getNombre())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre debe contener solo letras");
		}
		if (VetValidator.isGreater(dto.getMotivoIngreso(), 256)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el motivo de ingreso supera los 256 caracteres");
		}
		if (VetValidator.isMinor(dto.getMotivoIngreso(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST,
					"Error el motivo de ingreso no puede tener menos de 3 caracteres");
		}

		dto.setNombre(VetValidator.toCapitalize(dto.getNombre()));

		Pet entity = new Pet();
		entity.setId(id);
		entity.setNombre(dto.getNombre());
		entity.setEdad(dto.getEdad());
		entity.setMotivoIngreso(dto.getMotivoIngreso());
		entity.setParent(new Parent(dto.getParentDTO().getId()));
		repository.save(entity);
		entity = repository.getById(entity.getId());

		// Lleno mi DTO respuesta con los datos que debo responder
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setEdad(entity.getEdad());
		dto.setMotivoIngreso(entity.getMotivoIngreso());
		ParentDTO parentDTO = new ParentDTO();
		parentDTO.setId(entity.getParent().getId());
		parentDTO.setNombre(entity.getParent().getNombre());
		dto.setParentDTO(parentDTO);

		return dto;

	}

}
