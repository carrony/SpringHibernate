package com.dred.hibernate.modelos.dao;

import java.util.List;

import com.dred.hibernate.modelos.Usuario;

public interface UsuarioDAO {
	public List<Usuario> getListaUsuarios();
	public Usuario getUsuario(Long idUsuario);
	public void guardarUsuario(Usuario usuario);
	public void eliminarUsuario(Long idUsuario);
	public List<Usuario> getListaUsuarios(String tipo);
}
