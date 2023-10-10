package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoUsuario;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Ativo;
import br.com.senai.core.domain.Usuario;

public class DaoPostgresqlUsuario implements DaoUsuario {

	private final String INSERT = "INSERT INTO usuarios (login, senha, ativo) VALUES (?, ?, ?) ";
	private final String UPDATE = "UPDATE login = ?, senha = ?, ativo = ?" 
	+ " WHERE login  = ?";
	private final String SELECT_BY_LOGIN = "SELECT login, senha, ativo"
	+ " FROM usuarios WHERE login = ? ";
	private final String SELECT_BY_NOME = "SELECT login, senha, ativo"
	+ " FROM usuarios WHERE Upper(login) LIKE Upper(?) ";
	private final String SELECT_TODAS = "SELECT usuarios.login, usuarios.senha, usuarios.ativo"
			+ " FROM usuarios"
			+ " ORDER BY usuarios.login";
	private final String SELECT_BY_DESC_LOGIN = "SELECT login, senha, ativo "
			+ " FROM usuarios WHERE login = ? ";

	private Connection conexao;

	public DaoPostgresqlUsuario() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}

	public void inserir(Usuario usuario) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getAtivo().name());
			ps.execute();
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro na inserção " + " do usuario. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	public void alterar(Usuario usuario) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, false);
			ps = conexao.prepareStatement(UPDATE);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getAtivo().name());
			boolean isAlteracaoOK = ps.executeUpdate() == 1;
			if (isAlteracaoOK) {
				this.conexao.commit();
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, true);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao " + "alterar o usuario. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	public Usuario buscarPor(String login) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_LOGIN);
			;
			ps.setString(1, login);
			rs = ps.executeQuery();
			if (rs.next()) {
				return extrairDo(rs);
			}
			return null;
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao " + "buscar o usuario. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
	
	public List<Usuario> listarPor(String login) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_NOME);
			ps.setString(1, login);
			rs = ps.executeQuery();
			while (rs.next()) {
				usuarios.add(extrairDo(rs));
			} 
			return usuarios;
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ " listar os usuarios. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}

	private Usuario extrairDo(ResultSet rs) {
		try {
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			Ativo ativo = Ativo.valueOf(rs.getString("ativo"));
			return new Usuario(login, senha, ativo);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao"
		+ " extrair o usuario. Motivo: " + ex.getMessage());
		}
	}

	public List<Usuario> listarTodas() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_TODAS);
			rs = ps.executeQuery();
			while (rs.next()) {
				usuarios.add(extrairDo(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro na listagem do usuario. Motivo " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		return usuarios;
	}
	

 @Override
	 public Usuario buscarPorLogin(String login) {
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(SELECT_BY_DESC_LOGIN);
			ps.setString(1, login);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				return extrairDo(rs);
			}
			return null;
			
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao buscar o login do usuário. Motivo: " + e.getMessage());
		}
	}

}
