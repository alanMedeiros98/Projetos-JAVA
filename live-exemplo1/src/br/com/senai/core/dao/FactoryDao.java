package br.com.senai.core.dao;

import br.com.senai.core.dao.postgresql.DaoPostgresqlAluno;
import br.com.senai.core.dao.postgresql.DaoPostgresqlInscricao;
import br.com.senai.core.dao.postgresql.DaoPostgresqlUnidadeCurricular;

public class FactoryDao {

	private static FactoryDao instance;
	
	private FactoryDao() {}
	
	public DaoInscricao getDaoInscricao() {
		return new DaoPostgresqlInscricao();
	}
	
	public DaoAluno getDaoAluno() {
		return new DaoPostgresqlAluno();
	}
	
	public DaoUnidadeCurricular getDaoUnidadeCurricular() {
		return new DaoPostgresqlUnidadeCurricular();
	}
	
	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}
	
}
