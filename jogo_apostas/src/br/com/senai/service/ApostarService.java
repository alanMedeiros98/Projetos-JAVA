package br.com.senai.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import br.com.senai.entity.Aposta;
import br.com.senai.util.Conexao;

public class ApostarService {

	AnimalService animalService = new AnimalService();
	PessoaService pessoaService = new PessoaService();
	CorridaService corridaService = new CorridaService();
	
	public void inserir(Aposta aposta) {
		CorridaService serviceCorrida = new CorridaService();
		String sql = "insert into apostador(id_pessoa_aposta, id_animal_aposta, id_corrida_apostador) values (?,?,?)";
		
		
		
		try {
			Connection conn =  Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			try {
				ps.setInt(1, aposta.getPessoa().getId());
				ps.setInt(2, aposta.getAnimal().getId());
				ps.setInt(3, aposta.getCorrida().getId());
				
				
				ps.executeUpdate();
				conn.close();
				JOptionPane.showMessageDialog(null, "Aposta realizada!!");
			} catch (NullPointerException npe) {
				JOptionPane.showMessageDialog(null,"Não possui jogador para salvar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Aposta> ListarApostas(){
		ArrayList<Aposta> lista = new ArrayList<>();
		
		String sql = "select * from apostador";
		
		try {
			Connection conn = Conexao.conectaMysql();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Aposta aposta = new Aposta();
				aposta.setId(rs.getInt("id_aposta"));
				aposta.setPessoa(pessoaService.buscarPorCodigo(rs.getInt("id_pessoa_aposta")));
				aposta.setAnimal(animalService.buscarPorCodigo(rs.getInt("id_animal_aposta")));
				aposta.setCorrida(corridaService.buscarPorCodigo(rs.getInt("id_corrida_apostador")));
				lista.add(aposta);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
