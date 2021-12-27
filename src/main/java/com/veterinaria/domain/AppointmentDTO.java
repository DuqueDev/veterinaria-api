package com.veterinaria.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppointmentDTO {

	private Long id;

	private String descripcion;

	private String fechaRegistro;

	private String diagnostico;

	private int peso;

	private int temperatura;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pet")
	private PetDTO pet;

	@JsonProperty("doctor")
	private DoctorDTO doctor;

}
