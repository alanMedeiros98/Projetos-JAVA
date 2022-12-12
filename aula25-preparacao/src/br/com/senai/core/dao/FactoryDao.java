package br.com.senai.core.dao;

import br.com.senai.core.dao.postgresql.DaoPostgresqlEquipamento;

public class FactoryDao {

	private static FactoryDao instance;
	
	private FactoryDao() {}
	
	public DaoEquipamento getDaoEquipamento() {
		return new DaoPostgresqlEquipamento();
	}
	
	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}
	
}
