package br.com.senai.core.dao;

import br.com.senai.core.dao.postgresql.DaoPostgresqlProjeto;

public class FactoryDao {

	private static FactoryDao instance;
	
	private FactoryDao() {}
	
	public DaoProjeto getDaoProjeto() {
		return new DaoPostgresqlProjeto();
	}
	
	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}
	
}
