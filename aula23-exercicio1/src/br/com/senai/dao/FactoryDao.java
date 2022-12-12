package br.com.senai.dao;

import br.com.senai.dao.postgresql.DaoPostgresqlPaciente;

public class FactoryDao {

	public DaoPaciente getDaoPaciente() {
		return new DaoPostgresqlPaciente();
	}
	
}
