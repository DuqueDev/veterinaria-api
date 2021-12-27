package com.veterinaria.model.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.veterinaria.domain.PharmacyDTO;

import com.veterinaria.model.Pharmacy;

@Mapper(componentModel = "spring")
public interface PharmacyMapper {
	/**
	 * Method to map Appointment Entity to AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 */
	@Mappings({ @Mapping(target = "fechaVen", source = "fechaVen", dateFormat = "yyyy-MM-dd") })
	PharmacyDTO toDTO(Pharmacy entity, @MappingTarget PharmacyDTO dto);

	/**
	 * Method to map a List of Appointment Entity to List of AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 * @return
	 */
	List<PharmacyDTO> toDTO(List<Pharmacy> entity, @MappingTarget List<PharmacyDTO> dto);

	/**
	 * Method to map AppointmentDTO to Appointment Entity
	 * 
	 * @param dto
	 * @param entity
	 */
	@Mappings({ @Mapping(target = "fechaVen", source = "fechaVen", dateFormat = "yyyy-MM-dd") })
	Pharmacy toEntity(PharmacyDTO dto, @MappingTarget Pharmacy entity);

	/**
	 * Method to map AppointmentDTO to Appointment Entity
	 * 
	 * @param dto
	 * @param entity
	 */
	@Mappings({ @Mapping(target = "fechaVen", source = "fechaVen", dateFormat = "yyyy-MM-dd"),
		@Mapping(target= "id", source= "id", ignore= true)})
	Pharmacy toEntityWithoutId(PharmacyDTO dto, @MappingTarget Pharmacy entity);	

}


