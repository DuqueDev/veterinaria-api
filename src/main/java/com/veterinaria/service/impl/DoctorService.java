package com.veterinaria.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IDoctorRepository;
import com.veterinaria.domain.AppointmentDTO;
import com.veterinaria.domain.DoctorDTO;
import com.veterinaria.domain.ParentDTO;
import com.veterinaria.domain.PetDTO;
import com.veterinaria.exception.ApiError;
import com.veterinaria.model.Appointment;
import com.veterinaria.model.Doctor;
import com.veterinaria.model.Parent;
import com.veterinaria.model.Pet;
import com.veterinaria.model.mapstruct.AppointmentMapper;
import com.veterinaria.model.mapstruct.DoctorMapper;
import com.veterinaria.service.IDoctorService;
import com.veterinaria.util.VetValidator;

@Service
public class DoctorService implements IDoctorService {
	
	@Autowired
	private DoctorMapper mapper;

	@Autowired
	private IDoctorRepository repository;

	@Override
	public DoctorDTO save(DoctorDTO dto) {

		if (VetValidator.isGreater(dto.getNombre(), 156)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre supera los 156 caracteres");
		}
		if (VetValidator.isMinor(dto.getNombre(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre no puede tener menos de 3 caracteres");
		}
		if (!VetValidator.isAlpha(dto.getNombre())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre debe contener solo letras");
		}
		if (VetValidator.isGreater(dto.getEspecialidad(), 156)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre supera los 156 caracteres");
		}
		if (VetValidator.isMinor(dto.getEspecialidad(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre no puede tener menos de 3 caracteres");
		}
		if (!VetValidator.isAlpha(dto.getEspecialidad())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el diagnostico debe contener solo letras");
		}
		dto.setNombre(VetValidator.toCapitalize(dto.getNombre()));
		
		
//save
		Doctor entity = mapper.toEntity(dto, new Doctor());
		repository.save(entity);
		entity = repository.getById(entity.getId());
		mapper.toDTO(entity, dto);

		return dto;
	}

	@Override
	public List<DoctorDTO> getAll() {
		List<Doctor> listEntity = repository.findAll();
		return mapper.toDTO(listEntity, new ArrayList<>());
	}

	@Override
	public List<DoctorDTO> delete(Long id) {
		repository.deleteById(id);
		return getAll();
	}

	@Override
	public DoctorDTO update(Long id, DoctorDTO doctor) {
		repository.findById(id).orElseThrow();
		doctor.setId(id);

		Optional<Doctor> validationEntity = repository.findById(id);

		if (!validationEntity.isPresent()) {
			throw new ApiError(HttpStatus.BAD_REQUEST,
					"El id " + id + " no existe en la base de datos, verifique e intente de nuevo");
		}

		if (VetValidator.isGreater(doctor.getNombre(), 156)) {

		}
		if (VetValidator.isMinor(doctor.getNombre(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre no puede tener menos de 3 caracteres");
		}
		if (!VetValidator.isAlpha(doctor.getNombre())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el nombre debe contener solo letras");
		}

		doctor.setNombre(VetValidator.toCapitalize(doctor.getNombre()));

		Doctor entity = new Doctor();
		entity.setId(id);
		entity.setNombre(doctor.getNombre());
		entity.setEspecialidad(doctor.getEspecialidad());
		repository.save(entity);
		entity = repository.getById(entity.getId());

		// Lleno mi DTO respuesta con los datos que debo responder
		doctor.setId(entity.getId());
		doctor.setNombre(entity.getNombre());
		doctor.setEspecialidad(entity.getEspecialidad());

		return doctor;

	}

}
