package util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Conexao {

	public static Connection conectaMysql() {
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mundo_senai",
												"root",
												"root");
		} catch(Exception e){
			e.printStackTrace();
		}
		return (Connection) conn;
	}
}
