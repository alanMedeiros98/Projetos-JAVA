package br.com.senai.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.senai.entity.Animal;
import br.com.senai.util.Conexao;

public class AnimalService {

	public ArrayList<Animal> listarAnimal(){
		
		ArrayList<Animal> lista = new ArrayList<>();
		
		String sql = "select * from animal order by id_animal";
		
		try {
			
			Connection conn = Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Animal a = new Animal();
				
				a.setId(rs.getInt("id_animal"));
				a.setNome(rs.getString("nome"));
				lista.add(a);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

	public Animal buscarPorCodigo(int codigo) {
		Animal a = new Animal();
		String sql = "select * from animal where id_animal = ?";
		
		try {
			
			Connection conn = Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
								
				a.setId(rs.getInt("id_animal"));
				a.setNome(rs.getString("nome"));
				
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
		
	}
	
	
}
