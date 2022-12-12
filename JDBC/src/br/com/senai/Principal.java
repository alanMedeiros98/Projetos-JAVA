package br.com.senai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String db = "jdbc:postgresql://containers-us-west-102.railway.app:5809/railway";
		String user = "postgres";
		String pass = "qh2DYSv0tKHednL2xHcu";
		
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager.getConnection(db, user, pass);
		System.out.println("a conexão foi realizada");
		
		PreparedStatement psInsert = conn.prepareStatement("insert into adquirentes (nome) values (?)");
		
		psInsert.setString(1, "Teste Laudelino");
		
		int qtdeDeRegistros = psInsert.executeUpdate();
		
		if(qtdeDeRegistros == 1) {
			System.out.println("Adquirentes criada com sucesso!!");
		}
		
		psInsert.close();
		
		PreparedStatement ps = conn.prepareStatement("select id, nome from adquirentes");
		
		ResultSet rs = ps.executeQuery();
		
		List<Adquirente> adquirentes = new ArrayList<Adquirente>();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			Adquirente adquirente = new Adquirente(id, nome);
			adquirentes.add(adquirente);
		}
		
		Adquirente adquirente = adquirentes.get(0);
		
		PreparedStatement psUpdate = conn.prepareStatement("update adquirentes set nome = ? where id = ?");
		
		psUpdate.setString(1, "Adquirente alterada");
		psUpdate.setInt(2, adquirente.getId());
		
		int qtdeDeLinhasAlteradas = psUpdate.executeUpdate();
		if (qtdeDeLinhasAlteradas == 1) {
			System.out.println("Adquirente alterada com sucesso!!");
		}
		
		psUpdate.close();
		
		PreparedStatement psDelete = conn.prepareStatement("delete from adquirentes where id = ?");
		psDelete.setInt(1, 23);
		
		int qtdeDeLinhasRemovidas = psDelete.executeUpdate();
		if (qtdeDeLinhasRemovidas == 1) {
			System.out.println("Adquirente removida com sucesso!!");
		}
		
		psDelete.close();
		
		ps.close();
		rs.close();
		conn.close();
		
		for (Adquirente ad : adquirentes) {
			System.out.println("Adquirente: id= " + ad.getId() + " / nome= " + ad.getNome());
		}
		
		System.out.println("O programa foi realizado");
		
	}

}
