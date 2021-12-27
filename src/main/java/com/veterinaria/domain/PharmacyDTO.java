package com.veterinaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PharmacyDTO {

	private Long id;

	private String nombre;

	private String fechaVen;

	private int cantidad;

}
