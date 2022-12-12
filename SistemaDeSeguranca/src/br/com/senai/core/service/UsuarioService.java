package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoUsuario;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Usuario;

public class UsuarioService {
	
	private DaoUsuario daoUsuario;
	
	public UsuarioService() {
		this.daoUsuario = FactoryDao.getInstance().getDaoUsuario();
		
	}
	
	public void salvar(Usuario usuario) {
		this.validarCadastro(usuario);
		boolean isJaPersistido = !usuario.getLogin().isEmpty();
		if (isJaPersistido) {
			this.daoUsuario.inserir(usuario);
		} else {
			this.daoUsuario.alterar(usuario);
		}
	}
	
	
	private void validarCadastro(Usuario usuario) {
		if (usuario != null) {
			

			Usuario usuarioCadastrado = daoUsuario.buscarPorLogin(usuario.getLogin());
			
			if (usuarioCadastrado != null && usuarioCadastrado.getLogin() != usuario.getLogin()) {
				throw new IllegalArgumentException("O login inserido já está cadastrado");
			}
			
			boolean isLoginInvalida = usuario.getLogin() == null;
			if (isLoginInvalida) {
				throw new IllegalArgumentException("O nome do login é obrigatório.");
			}
			
			boolean isSenhaInvalida = usuario.getSenha() == null;
			if (isSenhaInvalida) {
				throw new IllegalArgumentException("A senha do login é obrigatório.");
			}
			boolean isConfirmacaoInvalida = usuario.getConfirmacaoSenha() == null
				|| !usuario.getSenha().equals(usuario.getConfirmacaoSenha());
			if (isConfirmacaoInvalida) {
				throw new IllegalArgumentException("A senha do login e da confirmação devem ser a mesma.");
			}
			
			
		}
	}
	
	public  List<Usuario> listarPor(String login) {
		if (login != null && !login.isBlank()) {
			String filtro = "%" + login + "%";
			return daoUsuario.listarPor(filtro);
		} else {
			throw new IllegalArgumentException("O filtro para listagem é obrigatório.");
		}
		
	}
	
	public List<Usuario> listarTodas() {
		return daoUsuario.listarTodas();
	}
  
}
