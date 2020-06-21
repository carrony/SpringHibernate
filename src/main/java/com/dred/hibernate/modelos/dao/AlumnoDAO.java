package com.dred.hibernate.modelos.dao;

import java.util.List;

import com.dred.hibernate.modelos.Alumno;

public interface AlumnoDAO {
	public List<Alumno> getListaAlumnos();
	public Alumno getAlumno(String dni);
	public void guardarAlumno(Alumno alumno);
	public void eliminarAlumno(String dni);
}
