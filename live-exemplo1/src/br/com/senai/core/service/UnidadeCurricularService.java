package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoUnidadeCurricular;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.UnidadeCurricular;

public class UnidadeCurricularService {

	private DaoUnidadeCurricular dao;
	
	public UnidadeCurricularService() {
		this.dao = FactoryDao.getInstance().getDaoUnidadeCurricular();
	}
	
	public List<UnidadeCurricular> listarTodas(){
		return dao.listarTodas();
	}
	
}
