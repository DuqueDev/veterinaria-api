package com.veterinaria.model.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;


import org.mapstruct.MappingTarget;

import com.veterinaria.domain.DoctorDTO;

import com.veterinaria.model.Doctor;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

	/**
	 * Method to map Appointment Entity to AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 */
	DoctorDTO toDTO(Doctor entity, @MappingTarget DoctorDTO dto);

	/**
	 * Method to map a List of Appointment Entity to List of AppointmentDTO
	 * 
	 * @param entity
	 * @param dto
	 * @return
	 */
	List<DoctorDTO> toDTO(List<Doctor> entity, @MappingTarget List<DoctorDTO> dto);

	/**
	 * Method to map AppointmentDTO to Appointment Entity
	 * 
	 * @param dto
	 * @param doctor
	 */

	Doctor toEntity(DoctorDTO dto, @MappingTarget Doctor doctor);
}
