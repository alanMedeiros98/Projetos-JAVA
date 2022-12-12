package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Aluno;

public interface DaoAluno {

	public List<Aluno> listarPor(String nome);
	
}
