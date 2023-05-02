package br.com.senai.core.dao;

import br.com.senai.core.dao.postgresql.DaoPostgresqlContato;

public class FactoryDao {

	private static FactoryDao instance;
	
	private FactoryDao() {}
	
	public DaoContato getDaoContato() {
		return new DaoPostgresqlContato();
	}
	
	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}
	
}
