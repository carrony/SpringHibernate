package com.dred.hibernate.modelos;

import javax.persistence.Entity;

@Entity
public class ProfesorPlantilla extends Profesor {

	private Double salario;
	
	public ProfesorPlantilla() {
	}

	public ProfesorPlantilla(String nombre, String apellidos, String telefono, Double salario) {
		super(nombre, apellidos, telefono);
		this.salario=salario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "ProfesorPlatilla [getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getTelefono()=" + getTelefono() + ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfesorPlantilla other = (ProfesorPlantilla) obj;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
	
	
	
	
}
