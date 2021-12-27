package com.veterinaria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Entity(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion", length = 256, nullable = false, unique = false)
	private String descripcion;

	@Column(name = "fecha_registro", nullable = false, unique = false)
	private Date fechaRegistro;

	@Column(name = "diagnostico", nullable = false, unique = false)
	private String diagnostico;
	
	@Column(name = "peso", nullable = false, unique = false)
	private int peso;
	
	@Column(name = "temperatura", nullable = false, unique = false)
	private int temperatura;

	@ManyToOne
	@JoinColumn(name = "pets_id", nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Pet pet;

	@OneToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Doctor doctor;
	
	/**
	 * Empty constructor
	 */
	public Appointment() {

	}

	/**
	 * Constructror with mandatory fields
	 * 
	 * @param descripcion
	 * @param fechaRegistro
	 * @param diagnostico
	 */
	public Appointment(String descripcion, Date fechaRegistro, String diagnostico) {
		super();
		this.descripcion = descripcion;
		this.fechaRegistro = fechaRegistro;
		this.diagnostico = diagnostico;
	}

}
