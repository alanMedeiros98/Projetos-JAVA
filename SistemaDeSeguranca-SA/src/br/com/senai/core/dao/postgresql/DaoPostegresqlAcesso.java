package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoLogAcesso;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.LogsAcesso;
import br.com.senai.core.domain.Usuario;

public class DaoPostegresqlAcesso implements DaoLogAcesso{
	
	private final String INSERT = "INSERT INTO logs_acessos (data_hora, login) "
			+ " VALUES (?, ?)";
	private final String SELECT_BY_LOGIN = "SELECT la.id, la.data_hora, la.login, u.senha, u.login " 
			+ "FROM logs_acessos la "
			+ "inner join usuarios u "
			+ "on la.login = u.login "
			+ "WHERE Upper(la.login) LIKE Upper(?) ORDER BY la.id";
	
	private Connection conexao;
	
	public DaoPostegresqlAcesso() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	public void inserir(LogsAcesso acesso) {
		PreparedStatement ps = null;
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		@SuppressWarnings("unused")
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(time.getTime());
		Timestamp t = new Timestamp(time.getTime());
		
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setTimestamp(1, t);
			ps.setString(2, acesso.getLogin().getLogin());
			
			ps.execute();
			
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "inserir o acesso. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}
	
	public List<LogsAcesso> listarPor(String login) {
		List<LogsAcesso> logs = new ArrayList<LogsAcesso>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_LOGIN);
			ps.setString(1, login);
			rs = ps.executeQuery();
			while (rs.next()) {
				logs.add(extrairDo(rs));
			}
			return logs;
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "listar o acesso. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		
	}
	private LogsAcesso extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			LocalDateTime dataHora = rs.getTimestamp("data_hora").toLocalDateTime();
		
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			Usuario usuario = new Usuario(login, senha);
		
			return new LogsAcesso(id, dataHora, usuario);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "extrair o acesso. Motivo: " + ex.getMessage());
		}
	}
	
	
	
	

}
