package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.LogsAcesso;

public interface DaoLogAcesso {

	public void inserir(LogsAcesso acesso);
	
	public List<LogsAcesso> listarPor(String login);
	
}
