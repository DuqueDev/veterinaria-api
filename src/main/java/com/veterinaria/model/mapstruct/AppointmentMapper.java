package com.veterinaria.model.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.MappingTarget;

import com.veterinaria.domain.AppointmentDTO;
import com.veterinaria.model.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

	
	@Mappings({ @Mapping(target = "fechaRegistro", source = "fechaRegistro", dateFormat = "yyyy-MM-dd HH:mm:ss") })
	AppointmentDTO toDTO(Appointment entity, @MappingTarget AppointmentDTO dto);
	
	/**
	 * Method to map a List of Appointment Entity to List
	 * of AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 * @return
	 */
	List<AppointmentDTO> toDTO(List<Appointment> entity, @MappingTarget List<AppointmentDTO> dto);

	/**
	 * Method to map AppointmentDTO to Appointment Entity
	 * 
	 * @param dto
	 * @param entity
	 */
	@Mappings({ @Mapping(target = "fechaRegistro", source = "fechaRegistro", dateFormat = "yyyy-MM-dd HH:mm:ss") })
	Appointment toEntity(AppointmentDTO dto, @MappingTarget Appointment entity);
}
