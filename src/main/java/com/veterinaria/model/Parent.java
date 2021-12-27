package com.veterinaria.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "parent")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 156, nullable = false, unique = false)
	private String nombre;
	
	@Column(name = "direccion", length = 156, nullable = false, unique = false)
	private String direccion;
	
	@Column(name = "telefono", length = 156, nullable = false, unique = false)
	private String telefono;
	
	
	@OneToMany(mappedBy="parent")
	private Set<Pet> pet;
	
	public Parent() {
		super();
	}

	public Parent(Long id) {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, id, nombre, pet, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		return Objects.equals(direccion, other.direccion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(pet, other.pet)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", pet=" + pet + "]";
	}

	
}
