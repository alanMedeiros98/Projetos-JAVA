package br.com.senai.core.service;

import br.com.senai.core.dao.DaoUsuario;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Login;
import br.com.senai.core.domain.Usuario;

public class LoginService {
	
	private DaoUsuario daoUsuario;
	
	public LoginService() {
		this.daoUsuario  = FactoryDao.getInstance().getDaoUsuario();
	}
	
	
	public void validar(Login login) {
		boolean loginIsInvalido = login.getLogin() == null;
		if (loginIsInvalido) {
			throw new RuntimeException("O login não pode ser nulo");
		}
		boolean isSenhaInvalida = login.getSenha() == null;
		if (isSenhaInvalida) {
			throw new RuntimeException("A senha não pode ser nula");

		}
		Usuario usuarioExiste = daoUsuario.buscarPor(login.getLogin());
		
		if (usuarioExiste == null || !login.getSenha().equals(usuarioExiste.getSenha()) ) {
			throw new RuntimeException("O login ou a senha não existe.");
		}
		
				
		
	}
	
	

}
