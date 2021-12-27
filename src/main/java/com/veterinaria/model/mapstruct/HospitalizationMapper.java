package com.veterinaria.model.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.veterinaria.domain.HospitalizationDTO;

import com.veterinaria.model.Hospitalization;

@Mapper(componentModel = "spring")
public interface HospitalizationMapper {
	/**
	 * Method to map Appointment Entity to AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 */
	@Mappings({ @Mapping(target = "fechaEntrada", source = "fechaEntrada", dateFormat = "yyyy-MM-dd HH:mm:ss"),
			@Mapping(target = "fechaSalida", source = "fechaSalida", dateFormat = "yyyy-MM-dd HH:mm:ss") })
	HospitalizationDTO toDTO(Hospitalization entity, @MappingTarget HospitalizationDTO dto);

	/**
	 * Method to map a List of Appointment Entity to List of AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 * @return
	 */
	List<HospitalizationDTO> toDTO(List<Hospitalization> entity, @MappingTarget List<HospitalizationDTO> dto);

	/**
	 * Method to map AppointmentDTO to Appointment Entity
	 * 
	 * @param dto
	 * @param entity
	 */
	@Mappings({ @Mapping(target = "fechaEntrada", source = "fechaEntrada", dateFormat = "yyyy-MM-dd HH:mm:ss"),
			@Mapping(target = "fechaSalida", source = "fechaSalida", dateFormat = "yyyy-MM-dd HH:mm:ss") })
	Hospitalization toEntity(HospitalizationDTO dto, @MappingTarget Hospitalization hospitalization);

}
