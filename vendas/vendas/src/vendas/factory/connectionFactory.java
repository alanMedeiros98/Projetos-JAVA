package vendas.factory;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class connectionFactory {
	//nome usuario	
	private static final String USERNAME = "root";
	
	//senha usuario
	private static final String PASSWORD = "";
	
	//caminho banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/vendas";
	
	//conexão banca de dados
	public static Connection createConnectionToMySQL() throws Exception {
		
		//faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		//cria conexão com o banco de dados
		Connection connection = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		//recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//testar se a conexão é nula
		if(con != null) {
			System.out.println("conexão obtida!");
			con.close();
		}
	}
}
