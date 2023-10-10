package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoColaborador;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Colaborador;

public class ColaboradorService {
	
	private DaoColaborador daoColaborador;
	
	public ColaboradorService() {
		this.daoColaborador = FactoryDao.getInstance().getDaoColaborador();
	
	}
	
	public List<Colaborador> listarTodas() {
		return daoColaborador.listarTodas();
	}

}
