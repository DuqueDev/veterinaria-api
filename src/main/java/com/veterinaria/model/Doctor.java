package com.veterinaria.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 156, nullable = false, unique = false)
	private String nombre;
	
	@Column(name="especialidad", length = 156, nullable = false, unique= false )
	private String especialidad;

	@OneToMany(mappedBy = "doctor")
	private Set<Pet> pet;

	public Doctor() {
		super();
	}

	public Doctor(Long id) {
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

	public Set<Pet> getPet() {
		return pet;
	}

	public void setPet(Set<Pet> pet) {
		this.pet = pet;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", nombre=" + nombre + ", pet=" + pet + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, pet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre) && Objects.equals(pet, other.pet);
	}
	
	
}
