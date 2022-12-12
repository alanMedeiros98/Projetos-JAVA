package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Projeto;

public interface DaoProjeto {

	public void inserir(Projeto projeto);
	
	public void alterar(Projeto projeto);
	
	public void excluirPor(int id);
	
	public Projeto buscarPor(int id);
	
	public List<Projeto> listarPor(String descricaoCurta);
	
}
