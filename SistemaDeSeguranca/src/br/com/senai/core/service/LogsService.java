package br.com.senai.core.service;

import br.com.senai.core.dao.DaoLogAcesso;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Login;
import br.com.senai.core.domain.LogsAcesso;

public class LogsService {
	
	private Login login;

	private DaoLogAcesso daoLogs;
	
	public LogsService() {
		this.daoLogs = FactoryDao.getInstance().getDaoLogAcesso();
	}
	
	public void salvar(LogsAcesso acesso) {
		this.validar(acesso);
		this.daoLogs.inserir(acesso);
	}
	
	private void validar(LogsAcesso acesso) {
		if (acesso != null) {
			
			boolean isLoginInvalido = acesso.getLogin() == null;
			
			if (isLoginInvalido) {
				throw new IllegalArgumentException("Não foi possivel registrar o acesso");
			}
		}else {			
			throw new IllegalArgumentException("O login não pode ser nulo");
		}
	}
	
	
}
