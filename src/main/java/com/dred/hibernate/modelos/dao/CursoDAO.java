package com.dred.hibernate.modelos.dao;

import java.util.List;

import com.dred.hibernate.modelos.Curso;

public interface CursoDAO {
	public List<Curso> getListaCursos();
	public Curso getCurso(Long idCurso);
	public void guardarCurso(Curso curso);
	public void eliminarCurso(Long idCurso);
}
