package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Colaborador;

public interface DaoColaborador {
	
	
	public List<Colaborador> listarTodas();

	public Colaborador buscarPor(int id);

}
