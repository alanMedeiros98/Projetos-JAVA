package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Usuario;

public interface DaoUsuario {
	
	public void inserir(Usuario usuario);
	public void alterar(Usuario usuario) ;
	public Usuario buscarPor(String login);
	public List<Usuario> listarTodas();
	public List<Usuario> listarPor(String login);
	 public Usuario buscarPorLogin(String login);
}
