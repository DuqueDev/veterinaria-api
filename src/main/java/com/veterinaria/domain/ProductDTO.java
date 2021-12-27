package com.veterinaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {

	private Long id;

	private String tipoProducto;

	private String nombreProducto;

	private Double valor;

	private int cantidad;

}
