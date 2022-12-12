package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoColaborador;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Colaborador;

public class DaoPostgresqlColaborador implements DaoColaborador {

	private final String SELECT_TODAS = "SELECT "
			+ " colaboradores.id, "
			+ " colaboradores.nome_completo "			
			+ " FROM colaboradores "
			+ " ORDER BY colaboradores.nome_completo";
	
	private final String SELECT_BY_ID = "SELECT id, nome_completo,"
			+ " nome_mae, cpf, rg, data_admissao, id_cargo,"
			+ " id_departamento FROM"
			+ " colaboradores WHERE id = ?";
	
	private Connection conexao;
	
	public DaoPostgresqlColaborador() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	public DaoPostgresqlColaborador(Connection conexao) {
		this.conexao = conexao;
	}
	
	public Colaborador extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String nomeCompleto = rs.getString("nome_completo");			
			return new Colaborador(id, nomeCompleto);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro "
					+ " ao extrair o envolvido. Motivo: " + ex.getMessage());
		}
	}
	
	public Colaborador buscarPor(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return extrairDo(rs);
			}
			return null;
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "buscar o colaborador. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
	
	
	
	public List<Colaborador> listarTodas() {
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_TODAS);
			rs = ps.executeQuery();
			while (rs.next()) {
				colaboradores.add(extrairDo(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro na listagem de colaboradores. Motivo "
					+ ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		return colaboradores;
	}
}
