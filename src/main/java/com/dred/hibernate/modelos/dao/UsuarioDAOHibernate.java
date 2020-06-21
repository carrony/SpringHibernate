package com.dred.hibernate.modelos.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dred.hibernate.modelos.Usuario;

@Repository
@Transactional
public class UsuarioDAOHibernate implements UsuarioDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public List<Usuario> getListaUsuarios() {
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.todos",Usuario.class);
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	@Override
	public Usuario getUsuario(Long idUsuario) {
		return em.find(Usuario.class, idUsuario);
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		if (usuario.getIdUsuario() == null) {
			em.persist(usuario);
		} else {
			em.merge(usuario);
		}
	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		Usuario curso = getUsuario(idUsuario);
		if (idUsuario!=null) {
			em.remove(idUsuario);
			em.flush();
		}
	}

	@Override
	public List<Usuario> getListaUsuarios(String tipo) {
		TypedQuery<Usuario> query = em.createNamedQuery("Cursos.buscaEnTipo",Usuario.class);
		query.setParameter("texto", tipo);
		List<Usuario> lista = query.getResultList();
		return lista;
	}

}
