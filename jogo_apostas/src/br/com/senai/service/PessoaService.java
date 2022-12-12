package br.com.senai.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.senai.entity.Cidade;
import br.com.senai.entity.Pessoa;
import br.com.senai.util.Conexao;


public class PessoaService {

	CidadeService serviceCidade = new CidadeService();
	
	public void inserir(Pessoa pessoa) {
		
		String sql = "insert into pessoa (nome, idade, id_pessoa_cidade) values (?, ?, ?)";
		
		try {
			Connection conn =  Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getIdade());
			ps.setInt(3, pessoa.getCidade().getId());
			ps.executeUpdate();
			conn.close();
			JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!!");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<Pessoa> listarPessoa() {
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		
		
		String sql = "select * from pessoa p order by nome";
		
		try {
			Connection conn = Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id_pessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setIdade(rs.getInt("idade"));
				pessoa.setCidade(serviceCidade.buscarPorCodigo(rs.getInt("id_pessoa_cidade")));
				lista.add(pessoa);				
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return lista;
	}

	public Pessoa buscarPorCodigo(int codigo) {
		Pessoa p = new Pessoa();
		String sql= "select * from pessoa where id_pessoa = ?";
		
		try {
			Connection conn =  Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				p.setId(rs.getInt("id_pessoa"));
				p.setNome(rs.getString("nome"));
				p.setIdade(rs.getInt("idade"));
				p.setCidade(serviceCidade.buscarPorCodigo(rs.getInt("id_pessoa_cidade")));
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	
	
	
}
