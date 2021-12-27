package com.veterinaria.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoctorDTO {

	private Long id;

	private String nombre;

	private String especialidad;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<PetDTO> pets;

}
