package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Inscricao;

public interface DaoInscricao {

	public void inserir(List<Inscricao> inscricoes);
	
	public void excluirPor(int idDoAluno, int idDaUnidade);
	
	public List<Inscricao> listarPor(int idDoAluno);
	
	public void atualizarPor(int idDoAluno, int idDaUnidade, double mediaFinal);
	
}
