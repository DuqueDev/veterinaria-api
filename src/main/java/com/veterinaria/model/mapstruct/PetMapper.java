package com.veterinaria.model.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import com.veterinaria.domain.PetDTO;
import com.veterinaria.model.Appointment;
import com.veterinaria.model.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {
	/**
	 * Method to map Appointment Entity to AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 */

	PetDTO toDTO(Pet entity, @MappingTarget PetDTO dto);

	/**
	 * Method to map a List of Appointment Entity to List of AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 * @return
	 */
	List<PetDTO> toDTO(List<Pet> entity, @MappingTarget List<PetDTO> dto);

	/**
	 * Method to map AppointmentDTO to Appointment Entity
	 * 
	 * @param dto
	 * @param entity
	 */

	Pet toEntity(PetDTO dto, @MappingTarget Pet entity);

}
