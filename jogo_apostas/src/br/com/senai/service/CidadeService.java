package br.com.senai.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.senai.entity.Cidade;

import br.com.senai.util.Conexao;


public class CidadeService {

	public void inserir(Cidade cidade) {

		String sql = "insert into cidade (nome, uf) values (?, ?)";

		try {
			Connection conn = Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cidade.getNome());
			ps.setString(2, cidade.getUf());
			ps.executeUpdate();
			conn.close();
			JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cidade> listarCidade() {
		ArrayList<Cidade> lista = new ArrayList<Cidade>();
		
		String sql = "select * from cidade order by nome";
		
		try {
			Connection conn = Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Cidade cid = new Cidade();
				cid.setId(rs.getInt("id_cidade"));
				cid.setNome(rs.getString("nome"));
				cid.setUf(rs.getString("uf"));
				lista.add(cid);				
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	public Cidade buscarPorCodigo(int codigo) {
		Cidade c = new Cidade();
		String sql= "select * from cidade where id_cidade = ?";
		
		try {
			Connection conn = Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				c.setId(rs.getInt("id_cidade"));
				c.setNome(rs.getString("nome"));
				c.setUf(rs.getString("uf"));
								
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	

}
