package com.dred.hibernate.modelos;

import javax.persistence.Entity;

@Entity
public class ProfesorFreelance extends Profesor {

	private Double precioHora;	
	
	public ProfesorFreelance() {
	}

	public ProfesorFreelance(String nombre, String apellidos, String telefono, Double precioHora) {
		super(nombre, apellidos, telefono);
		this.precioHora=precioHora;
	}

	public Double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(Double precioHora) {
		this.precioHora = precioHora;
	}

	@Override
	public String toString() {
		return "ProfesorFreelance [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getApellidos()="
				+ getApellidos() + ", getTelefono()=" + getTelefono() + ", precioHora=" + precioHora + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((precioHora == null) ? 0 : precioHora.hashCode());
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
		ProfesorFreelance other = (ProfesorFreelance) obj;
		if (precioHora == null) {
			if (other.precioHora != null)
				return false;
		} else if (!precioHora.equals(other.precioHora))
			return false;
		return true;
	}
	
	

}
