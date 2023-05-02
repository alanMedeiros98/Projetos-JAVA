package br.com.senai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDB {

	private Connection conexao;
	
	private static ManagerDB instance;
	
	private ManagerDB() {
		try {
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
			this.conexao = DriverManager.getConnection("jdbc:postgresql://containers-us-west-102.railway.app:5809/railway", "postgres", "qh2DYSv0tKHednL2xHcu");
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro de conexão, motivo: " + e.getMessage());
		}
	}
	
	public void configurarAutoCommit(Connection conn, boolean isHabilitado) {
		try {
			if (conn != null) {
				conn.setAutoCommit(isHabilitado);
			}
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na configuração do AutoCommit, motivo:" + e.getMessage());
		}
	}
	
	public void fechar(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao fechar o PrepareStatement, motivo: " + e.getMessage());
		}
	}
	
	public void fechar(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao fechar o ResultSet, Motivo: " + e.getMessage());
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}
	
	public static ManagerDB getInstance() {
		if (instance == null) {
			instance = new ManagerDB();
		}
		
		return instance;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
