package br.com.senai.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection conectaMysql() {
		Connection conn =null;
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jogo_de_aposta",
					"root",
					""					
					);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
