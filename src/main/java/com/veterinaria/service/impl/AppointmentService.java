package com.veterinaria.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.veterinaria.dao.IAppointmentRepository;
import com.veterinaria.domain.AppointmentDTO;
import com.veterinaria.domain.DoctorDTO;
import com.veterinaria.domain.PetDTO;
import com.veterinaria.exception.ApiError;
import com.veterinaria.model.Appointment;
import com.veterinaria.model.Doctor;
import com.veterinaria.model.Pet;
import com.veterinaria.model.mapstruct.AppointmentMapper;
import com.veterinaria.service.IAppointmentService;
import com.veterinaria.util.DateConverter;
import com.veterinaria.util.VetValidator;

@Service

public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentRepository repository;
	
	@Autowired
	private AppointmentMapper mapper;
	
	@Override
	public AppointmentDTO save(AppointmentDTO dto) {
		
		if (VetValidator.isGreater(dto.getDescripcion(), 256)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "La descripcion supera los 256 caracteres");
		}
		if (VetValidator.isMinor(dto.getDescripcion(), 3)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error la descripcion no puede tener menos de 3 caracteres");
		}
		if (VetValidator.isAlpha(dto.getDescripcion())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error la descripcion debe contener solo letras");
		}
		
		Appointment entity = mapper.toEntity(dto, new Appointment());
		repository.save(entity);
		entity = repository.getById(entity.getId());
		mapper.toDTO(entity, dto);
		return (dto);

	}

	/**
	 * Method to get all the appointments in entity Pet
	 */
	@Override

	public List<AppointmentDTO> getAll() {
		List<Appointment> listEntity = repository.findAll();
		return mapper.toDTO(listEntity, new ArrayList<>());
	}

	public List<AppointmentDTO> delete(Long id) {
		repository.deleteById(id);
		return getAll();
	}

	@Override
	public AppointmentDTO update(Long id, AppointmentDTO dto) {

		Optional<Appointment> validationEntity = repository.findById(id);

		if (!validationEntity.isPresent()) {
			throw new ApiError(HttpStatus.BAD_REQUEST,
					"El id " + id + " no existe en la base de datos, verifique e intente de nuevo");
		}

		if (!VetValidator.isGreater(dto.getDescripcion(), 156)) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error la descripcion no puede tener mas de 156 caracteres");
		}

		if (!VetValidator.isAlpha(dto.getDiagnostico())) {
			throw new ApiError(HttpStatus.BAD_REQUEST, "Error el diagnostico debe contener solo letras");
		}

		Appointment entity = new Appointment();
		entity.setId(id);
		entity.setDescripcion(dto.getDescripcion());
		entity.setFechaRegistro(DateConverter.strToDate(dto.getFechaRegistro()));
		entity.setDiagnostico(dto.getDiagnostico());
		//entity.setDoctor(new Doctor(dto.getDoctorDTO().getId()));
		//entity.setPet(new Pet(dto.getPetDTO().getId()));
		repository.save(entity);
		entity = repository.getById(entity.getId());

		// Lleno mi DTO respuesta con los datos que debo responder

		dto.setId(entity.getId());
		dto.setDescripcion(entity.getDescripcion());
		dto.setFechaRegistro(DateConverter.dateToStr(entity.getFechaRegistro()));
		dto.setDiagnostico(entity.getDiagnostico());
		PetDTO petDTO = new PetDTO();
		petDTO.setId(entity.getPet().getId());
		petDTO.setNombre(entity.getPet().getNombre());
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setId(entity.getDoctor().getId());
		doctorDTO.setNombre(entity.getDoctor().getNombre());

		return dto;

	}

}
