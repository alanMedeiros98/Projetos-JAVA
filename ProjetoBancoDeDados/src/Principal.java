import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String usuario = "postgres";
		String senha = "root";
		try {
		    Class.forName("org.postgresql.Driver");
		    Connection conexao = DriverManager.getConnection(url, usuario, senha);
		    System.out.println("Conexão feita com sucesso!!");
		    //JOptionPane.showMessageDialog(null, "Conexão feita com sucesso.");
		} catch (ClassNotFoundException e) {
		    // Erro caso o driver JDBC não foi instalado
		    e.printStackTrace();
		} catch (SQLException e) {
		    // Erro caso haja problemas para se conectar ao banco de dados
		    e.printStackTrace();
		}

	}

}
