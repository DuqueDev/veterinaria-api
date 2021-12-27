package com.veterinaria.domain;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PetDTO {

	private Long id;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nombre;

	private int edad;

	private String motivoIngreso;

	private String especie;

	private String raza;

	private String color;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("parent")
	private ParentDTO parentDTO;

	@JsonProperty("doctor")
	private DoctorDTO doctorDTO;

	
	}

