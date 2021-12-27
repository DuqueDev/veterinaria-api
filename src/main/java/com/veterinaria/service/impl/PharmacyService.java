package com.veterinaria.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IPharmacyRepository;
import com.veterinaria.domain.PharmacyDTO;
import com.veterinaria.exception.ApiError;
import com.veterinaria.model.Pet;
import com.veterinaria.model.Pharmacy;
import com.veterinaria.model.mapstruct.PharmacyMapper;
import com.veterinaria.service.IPharmacyService;
import com.veterinaria.util.Constants;
import com.veterinaria.util.DateConverter;
import com.veterinaria.util.VetValidator;

@Service
public class PharmacyService implements IPharmacyService {
	
	@Autowired
	public PharmacyMapper mapper;
	@Autowired
	private IPharmacyRepository repository;

	@Override
	public PharmacyDTO save(PharmacyDTO dto) {

		if (!VetValidator.isAlpha(dto.getNombre())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, Constants.ERROR_STRING_NOT_ALPHA);
		}
		if (VetValidator.isGreater(dto.getNombre(), 156)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, Constants.ERROR_STRING_MAYOR);
		}

		Pharmacy entity = mapper.toEntity(dto, new Pharmacy());
		repository.save(entity);
		entity = repository.getById(entity.getId());
		mapper.toDTO(entity, dto);
		return dto;
	}

	@Override
	public List<PharmacyDTO> getAll() {

		List<Pharmacy> listEntity = repository.findAll();
		return mapper.toDTO(listEntity, new ArrayList<>());

	}

	@Override
	public List<PharmacyDTO> delete(Long id) {
		repository.deleteById(id);
		return getAll();
	}

	@Override
	public PharmacyDTO update(Long id, PharmacyDTO dto) {
		
		Pharmacy entity = repository.findById(id).orElseThrow();
		entity=mapper.toEntityWithoutId(dto, entity);
		repository.save(entity);
		return mapper.toDTO(entity, dto);
		
	}

}
