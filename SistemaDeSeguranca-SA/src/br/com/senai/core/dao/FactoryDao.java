package br.com.senai.core.dao;

import br.com.senai.core.dao.postgresql.DaoPostegresqlAcesso;
import br.com.senai.core.dao.postgresql.DaoPostgresqlColaborador;
import br.com.senai.core.dao.postgresql.DaoPostgresqlEnvolvido;
import br.com.senai.core.dao.postgresql.DaoPostgresqlIncidente;
import br.com.senai.core.dao.postgresql.DaoPostgresqlOcorrencia;
import br.com.senai.core.dao.postgresql.DaoPostgresqlUsuario;

public class FactoryDao {
	
	private static FactoryDao instance;
	
	private FactoryDao() {}
	
	public DaoIncidente getDaoIncidente() {
		return new DaoPostgresqlIncidente();
	}
	
	public DaoEnvolvido getDaoEnvolvido() {
		return new DaoPostgresqlEnvolvido();
	}
	
	public DaoOcorrencia getDaoOcorrencia() {
		return new DaoPostgresqlOcorrencia();
	}
	
	public DaoColaborador getDaoColaborador() {
		return new DaoPostgresqlColaborador();
	}
	
	public DaoUsuario getDaoUsuario() {
		return new DaoPostgresqlUsuario();
	}
	
	public DaoLogAcesso getDaoLogAcesso() {
		return new DaoPostegresqlAcesso();
	}
	
	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}

}
