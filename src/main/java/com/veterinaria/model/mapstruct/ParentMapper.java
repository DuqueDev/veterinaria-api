package com.veterinaria.model.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;


import com.veterinaria.domain.ParentDTO;

import com.veterinaria.model.Parent;

@Mapper(componentModel = "spring")
public interface ParentMapper {
	/**
	 * Method to map Appointment Entity to AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 */

	ParentDTO toDTO(Parent entity, @MappingTarget ParentDTO dto);

	/**
	 * Method to map a List of Appointment Entity to List of AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 * @return
	 */
	List<ParentDTO> toDTO(List<Parent> entity, @MappingTarget List<ParentDTO> dto);

	/**
	 * Method to map AppointmentDTO to Appointment Entity
	 * 
	 * @param dto
	 * @param entity
	 */

	Parent toEntity(ParentDTO dto, @MappingTarget Parent entity);

}
