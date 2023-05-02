package br.com.senai.dao;

import java.util.List;

import br.com.senai.domain.Curso;

public interface DaoCurso {

	public void inserir(Curso curso);
	
	public void alterar(Curso curso);
	
	public void excluir(int id);
	
	public Curso buscarPor(int id);
	
	public List<Curso> listarPor(String descricaoCurta);
	
}
