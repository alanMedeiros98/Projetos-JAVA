package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import entity.Visitante;
import util.Conexao;

public class VisitanteService {

	public void inserirVisitante(Visitante v) {
		String sql = "insert into visitante (nome, email, telefone) values(?, ?, ?)";
		try {
			Connection conn = Conexao.conectaMysql();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, v.getNome());
			ps.setString(2, v.getEmail());
			ps.setString(3, v.getTelefone());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Visitante> listaTodos(){
		ArrayList<Visitante> lista = new ArrayList<Visitante>();
		
		String sql = "select 8 from visitante order by nome";
		try {
			Connection conn = Conexao.conectaMysql();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Visitante v = new Visitante();
				v.setId(rs.getInt("id"));
				v.setNome(rs.getString("nome"));
				v.setEmail(rs.getString("E-mail"));
				v.setTelefone(rs.getString("telefone"));
				lista.add(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Visitante> listaPorNome(String filtro){
		ArrayList<Visitante> lista = new ArrayList<Visitante>();
		
		String sql = "select 8 from visitante where nome like ?% order by nome";
		try {
			Connection conn = Conexao.conectaMysql();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Visitante v = new Visitante();
				v.setId(rs.getInt("id"));
				v.setNome(rs.getString("nome"));
				v.setEmail(rs.getString("E-mail"));
				v.setTelefone(rs.getString("telefone"));
				lista.add(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}
