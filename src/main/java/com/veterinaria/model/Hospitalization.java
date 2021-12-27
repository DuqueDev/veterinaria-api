package com.veterinaria.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "hospitalization")
public class Hospitalization {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "fecha_entrada", nullable = false, unique = false)
		private String fechaEntrada;
		
		@Column(name="fecha_salida", nullable = false, unique= false )
		private String fechaSalida;
		
		@Column(name="dias", nullable = false, unique= false )
		private int dias;
		
		@Column(name="valor", nullable = false, unique= false )
		private Double valor;

		@ManyToOne
		@JoinColumn(name = "pets_id", nullable = false)
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private Pet pet;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFechaEntrada() {
			return fechaEntrada;
		}

		public void setFechaEntrada(String fechaEntrada) {
			this.fechaEntrada = fechaEntrada;
		}

		public String getFechaSalida() {
			return fechaSalida;
		}

		public void setFechaSalida(String fechaSalida) {
			this.fechaSalida = fechaSalida;
		}

		public int getDias() {
			return dias;
		}

		public void setDias(int dias) {
			this.dias = dias;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		public Pet getPet() {
			return pet;
		}

		public void setPet(Pet pet) {
			this.pet = pet;
		}

		@Override
		public int hashCode() {
			return Objects.hash(dias, fechaEntrada, fechaSalida, id, pet, valor);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Hospitalization other = (Hospitalization) obj;
			return dias == other.dias && Objects.equals(fechaEntrada, other.fechaEntrada)
					&& Objects.equals(fechaSalida, other.fechaSalida) && Objects.equals(id, other.id)
					&& Objects.equals(pet, other.pet) && Objects.equals(valor, other.valor);
		}

		@Override
		public String toString() {
			return "Hospitalization [id=" + id + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
					+ ", dias=" + dias + ", valor=" + valor + ", pet=" + pet + "]";
		}

}