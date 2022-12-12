package br.com.senai.dao;

import br.com.senai.dao.postgresql.DaoPostgresqlCurso;

public class FactoryDao {

	public DaoCurso getDaoCurso() {
		return new DaoPostgresqlCurso();
	}
	
}
