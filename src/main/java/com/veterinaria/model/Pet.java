package com.veterinaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "pets")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 156, nullable = false, unique = false)
	private String nombre;

	@Column(name = "edad", nullable = false, unique = false)
	private int edad;

	@Column(name = "motivo_ingreso", nullable = false, unique = false)
	private String motivoIngreso;
	
	@Column (name = "especie",  nullable = false, unique = false)
	private String especie;
	
	@Column (name = "raza", nullable = false, unique = false)
	private String raza;
	
	@Column (name = "color", nullable = false, unique = false )
	private String color;

	@ManyToOne
	@JoinColumn(name = "parent_id", nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Parent parent;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Doctor doctor;

	public Pet() {
		super();
	}

	public Pet(Long id) {
		super();
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getMotivoIngreso() {
		return motivoIngreso;
	}

	public void setMotivoIngreso(String motivoIngreso) {
		this.motivoIngreso = motivoIngreso;
	}
	
	
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}
