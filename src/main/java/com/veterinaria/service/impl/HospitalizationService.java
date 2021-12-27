package com.veterinaria.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IHospitalizationRepository;

import com.veterinaria.domain.HospitalizationDTO;
import com.veterinaria.exception.ApiError;

import com.veterinaria.model.Hospitalization;

import com.veterinaria.model.mapstruct.HospitalizationMapper;
import com.veterinaria.service.IHospitalizationService;


@Service
public class HospitalizationService implements IHospitalizationService {

	@Autowired
	private HospitalizationMapper mapper;
	@Autowired
	private IHospitalizationRepository repository;
	

	/**
		 * Method to save Hospitalization
		 */
	@Override
	public HospitalizationDTO save(HospitalizationDTO dto) {

	Hospitalization entity = mapper.toEntity(dto, new Hospitalization());
	repository.save(entity);
	entity = repository.getById(entity.getId());
	mapper.toDTO(entity, dto);
	return dto;
	}


	/**
	 * Method to get all hospitalization
	 */
		@Override
		public List<HospitalizationDTO> getAll() {
			List<Hospitalization> listEntity = repository.findAll();
			return mapper.toDTO(listEntity, new ArrayList<>());
		}

	

	/**
	 * Method delete by id Hospitalization
	 */

	public List<HospitalizationDTO> delete(Long id) {
		repository.deleteById(id);
		return getAll();
	}

	/**
	 * Method update by id Hospitalization
	 */

	@Override
	public HospitalizationDTO update(Long id, HospitalizationDTO dto) {
		Optional<Hospitalization> validationEntity = repository.findById(id);

		if (!validationEntity.isPresent()) {
			throw new ApiError(HttpStatus.BAD_REQUEST,
					"El id " + id + " no existe en la base de datos, verifique e intente de nuevo");

		}

		Hospitalization entity = new Hospitalization();
		entity.setId(id);
		entity.setFechaEntrada(dto.getFechaEntrada());
		entity.setFechaSalida(dto.getFechaSalida());
		entity.setDias(dto.getDias());
		repository.save(entity);
		entity = repository.getById(entity.getId());

		// Lleno mi DTO respuesta con los datos que debo responder
		dto.setId(entity.getId());
		dto.setFechaEntrada(entity.getFechaEntrada());
		dto.setFechaSalida(entity.getFechaSalida());
		dto.setDias(entity.getDias());
		return dto;

	}

}
