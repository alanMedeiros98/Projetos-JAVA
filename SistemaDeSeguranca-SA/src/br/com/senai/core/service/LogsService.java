package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoLogAcesso;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.LogsAcesso;

public class LogsService {

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
	
	public List<LogsAcesso> listarAcessos(String login) {
		if (login != null & !login.isBlank()) {
			return daoLogs.listarPor(login);
		
		} else {
			throw new IllegalArgumentException("O filtro para listar é obrigatório.");
		}
	}
	
	
}
