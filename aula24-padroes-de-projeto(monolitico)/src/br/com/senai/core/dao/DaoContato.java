package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Contato;

public interface DaoContato {

	public void inserir(Contato contato);
	
	public void alterar(Contato contato);
	
	public void excluirPor(int id);
	
	public List<Contato> listarPor(String nomeCompleto);
	
}
