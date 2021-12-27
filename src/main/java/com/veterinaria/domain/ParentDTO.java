package com.veterinaria.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ParentDTO {

	private Long id;

	private String nombre;

	private String direccion;

	private String telefono;

	private List<PetDTO> pets;

}
