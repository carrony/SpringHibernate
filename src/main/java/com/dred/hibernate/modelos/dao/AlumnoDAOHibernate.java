package com.dred.hibernate.modelos.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dred.hibernate.modelos.Alumno;

@Repository
@Transactional
public class AlumnoDAOHibernate implements AlumnoDAO {

	@Autowired
	EntityManager em;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public List<Alumno> getListaAlumnos() {
		TypedQuery<Alumno> query = em.createNamedQuery("Alumno.todos",Alumno.class);
		List<Alumno> lista = query.getResultList();
		return lista;
	}

	@Override
	public Alumno getAlumno(String dni) {
		return em.find(Alumno.class, dni);
	}

	@Override
	public void guardarAlumno(Alumno alumno) {
		//Primero persistimos el usaurio
		if (alumno.getUsuario()!=null)
			usuarioDAO.guardarUsuario(alumno.getUsuario());
		
		if (alumno.getDni() == null) {
			em.persist(alumno);
		} else {
			em.merge(alumno);
		}
		
	}

	@Override
	public void eliminarAlumno(String dni) {
		Alumno curso = getAlumno(dni);
		if (dni!=null) {
			em.remove(dni);
			em.flush();
		}
	}

	

}
