package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import br.com.senai.core.dao.DaoLogAcesso;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Login;
import br.com.senai.core.domain.LogsAcesso;

public class DaoPostegresqlAcesso implements DaoLogAcesso{
	
	private final String INSERT = "INSERT INTO logs_acessos (id, data_hora, login) "
			+ " VALUES (?, ?, ?)";
	private final String SELECT_BY_ID = "SELECT id, data_hora, login"
			+ " FROM logs_acessos"
			+ " WHERE id = ?";
	
	private Connection conexao;
	
	public DaoPostegresqlAcesso() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	
	public void inserir(LogsAcesso acesso) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setInt(1, acesso.getId());
			ps.setString(2, acesso.getLogin().getLogin());
			ps.setTimestamp(3, Timestamp.valueOf(acesso.getDataHora()));
			ps.execute();
			
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "inserir o acesso. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}
	
	public LogsAcesso buscarPor(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return extrairDo(rs);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "buscar o acesso. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		
	}
	
	private LogsAcesso extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String login = rs.getString("login");
			LocalDateTime dataHora = rs.getTimestamp("data_hora").toLocalDateTime();
			Login loginSalvo = new Login(login, "");
		
			return new LogsAcesso(id, dataHora, loginSalvo);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "extrair o acesso. Motivo: " + ex.getMessage());
		}
	}
	
	
	
	

}
