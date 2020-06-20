package com.dred.hibernate.modelos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dred.hibernate.modelos.Curso;

@Repository
@Transactional
public class CursoDaoHibernate implements CursoDAO {
	
	@Autowired
	EntityManager em;

	@Override
	public List<Curso> getListaCursos() {
		TypedQuery<Curso> query = em.createQuery("FROM Curso curso",Curso.class);
		List<Curso> lista = query.getResultList();
		return lista;
	}

	@Override
	public Curso getCurso(Long idCurso) {
		return em.find(Curso.class, idCurso);
	}

	@Override
	public void guardarCurso(Curso curso) {
		if (curso.getIdCurso() == null) {
			em.persist(curso);
		} else {
			em.merge(curso);
		}
	}
	
	@Override
	public void eliminarCurso(Long idCurso) {
		Curso curso = getCurso(idCurso);
		if (curso!=null) {
			em.remove(curso);
			em.flush();
		}
	}

	

}
