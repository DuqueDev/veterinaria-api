package com.veterinaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_producto", length = 156, nullable = false, unique = false)
	private String tipoProductor;

	@Column(name = "nombre_producto", nullable = false, unique = false)
	private int nombreProducto;

	@Column(name = "valor", nullable = false, unique = false)
	private Double valor;
	
	@Column (name = "cantidad",  nullable = false, unique = false)
	private int cantidad;
	
	public Product() {
		super();
	}

	public Product(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoProductor() {
		return tipoProductor;
	}

	public void setTipoProductor(String tipoProductor) {
		this.tipoProductor = tipoProductor;
	}

	public int getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(int nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	

}
