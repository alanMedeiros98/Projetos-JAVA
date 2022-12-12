package br.com.senai.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.senai.entity.Corrida;
import br.com.senai.util.Conexao;

public class CorridaService {

	public void inserir(Corrida corrida) {
		String sql= "insert into corrida(sequencia) values (?)";
		
		try {
			Connection conn =  Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, corrida.getSequencia());
			ps.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Corrida> listarCorrida(){
		ArrayList<Corrida> lista = new ArrayList<>();
		
		String sql = "select * from corrida order by id_corrida desc";
		
		try {
			Connection conn =  Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Corrida c = new Corrida();
				c.setId(rs.getInt("id_corrida"));
				c.setSequencia(rs.getString("sequencia"));
				lista.add(c);
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	public Corrida buscarPorCodigo(int codigo) {
		Corrida c = new Corrida();
		String sql = "select * from corrida where id_corrida =?";
		
		try {
			Connection conn =  Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				c.setId(rs.getInt("id_corrida"));
				c.setSequencia(rs.getString("sequencia"));
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	 
	
	public void salvarCorrida(int animalVencedor) {
		Corrida c = new Corrida();
		CorridaService corridaService = new CorridaService();
		String sql = "update corrida set id_animal_vencedor = (?) where id_corrida= (?)";
		
		try {
			Connection conn =  Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, animalVencedor);
			
		
			ps.execute();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	
	
	
	
}
