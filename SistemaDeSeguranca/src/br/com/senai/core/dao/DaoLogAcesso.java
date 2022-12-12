package br.com.senai.core.dao;

import br.com.senai.core.domain.LogsAcesso;

public interface DaoLogAcesso {

	public void inserir(LogsAcesso acesso);
	
	public LogsAcesso buscarPor(int id);
	
}
