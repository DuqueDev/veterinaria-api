package com.veterinaria.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class HospitalizationDTO {

	private Long id;
	private String fechaEntrada;
	private String fechaSalida;
	private int dias;
	private double valor;
	private List<PetDTO> pets;

}
