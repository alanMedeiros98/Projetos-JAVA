package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoAluno;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Aluno;

public class AlunoService {

	private DaoAluno dao;
	
	public AlunoService() {
		this.dao = FactoryDao.getInstance().getDaoAluno();
	}
	
	public List<Aluno> listarPor(String nome){
		if (nome != null && !nome.isBlank()) {
			String filtro = "%" + nome + "%";
			return dao.listarPor(filtro);
		}
		throw new IllegalArgumentException("O filtro para listagem é obrigatório");
	}
	
}
