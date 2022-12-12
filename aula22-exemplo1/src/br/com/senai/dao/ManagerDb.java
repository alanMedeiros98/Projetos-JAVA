package br.com.senai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDb {
		
	private Connection conexao;
	
	private static ManagerDb instance;
	
	private ManagerDb() {
		try {
			Class.forName("org.postgresql.Driver")
					.getDeclaredConstructor().newInstance();
			this.conexao = DriverManager.getConnection("jdbc:postgresql://containers-us-west-102.railway.app:5809/railway", 
					"postgres", "qh2DYSv0tKHednL2xHcu");
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro de conexão. "
					+ "Motivo: " + e.getMessage());
		}
	}
	
	public void configurarAutocommit(Connection conexao, boolean isHabilitado) {
		try {
			if (conexao != null) {
				conexao.setAutoCommit(isHabilitado);
			}
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na configuração "
					+ "do autocommit. Motivo: " + e.getMessage());
		}
	}
	
	public void fechar(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao fechar "
					+ "o PreparedStatement. Motivo: " + e.getMessage());
		}
	}
	
	public void fechar(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();				
			}
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao fechar o "
					+ "ResultSet. Motivo: " + e.getMessage());
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}
	
	public static ManagerDb getInstance() {
		if (instance == null) {
			instance = new ManagerDb();
		}
		return instance;
	}

}
