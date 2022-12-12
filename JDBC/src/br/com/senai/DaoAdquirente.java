package br.com.senai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoAdquirente {

	private Connection conn;
	
	public DaoAdquirente() throws Exception {
	
		String db = "jdbc:postgresql://containers-us-west-102.railway.app:5809/railway";
		String user = "postgres";
		String pass = "qh2DYSv0tKHednL2xHcu";
		
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			this.conn = DriverManager.getConnection(db, user, pass);
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro");
		}
		
}

	public void inserir(Adquirente adquirente) {
		PreparedStatement psInsert = null;
		try {
			psInsert = conn.prepareStatement("insert into adquirentes(nome) values(?)");
			psInsert.setString(1, adquirente.getNome());
			psInsert.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro no inserção.");
		}finally {
			this.liberar(psInsert);
		}
	}

	public void alterar(Adquirente adquirente) {
		PreparedStatement psUpdate = null;
		try {
			this.conn.setAutoCommit(false);
			psUpdate = conn.prepareStatement("update adquirentes set nome = ? where id = ?");
			psUpdate.setString(1, adquirente.getNome());
			psUpdate.setInt(1, adquirente.getId());
			int qtdeDeLinhasAlteradas = psUpdate.executeUpdate();
			if (qtdeDeLinhasAlteradas <= 1) {
				this.conn.commit();
			}else {
				this.conn.rollback();
			}
			this.conn.setAutoCommit(true);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na alteração.");
		}finally {
			this.liberar(psUpdate);
		}
	}
	
	public void excluir(int id) {
		PreparedStatement psDelete = null;
		try {
			this.conn.setAutoCommit(false);
			psDelete = conn.prepareStatement("delete from adquirentes where id = ?");
			psDelete.setInt(1, id);
			int qtdeDeLinhasExcluidas = psDelete.executeUpdate();
			if (qtdeDeLinhasExcluidas <= 1) {
				this.conn.commit();
			}else {
				this.conn.rollback();
			}
			this.conn.setAutoCommit(true);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na exclusao.");
		}
	}
	
	public List<Adquirente> listarTodos(){
		List<Adquirente> adquirentes = new ArrayList<Adquirente>();
		PreparedStatement psSelect = null;
		
		try {
			psSelect = conn.prepareStatement("select id, nome from adquirentes order by nome");
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				adquirentes.add(new Adquirente(id, nome));
				
			}
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na listagem");
		}finally {
			this.liberar(psSelect);
		}
		this.fecharConn();
		
		return adquirentes;
	}
	
	public void fecharConn() {
		try {
			this.conn.close();
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro no encerramento da conexão");
		}
	}
	
	public void liberar(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro");
		}
	}
	
}
