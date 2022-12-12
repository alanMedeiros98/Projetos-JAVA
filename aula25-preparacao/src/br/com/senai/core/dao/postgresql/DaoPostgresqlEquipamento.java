package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoEquipamento;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Equipamento;
import br.com.senai.core.domain.Status;

public class DaoPostgresqlEquipamento implements DaoEquipamento{

	private final String INSERT = "INSERT INTO equipamentos (descricao_curta, "
			+ "especificacoes, garantia, status) VALUES (?, ?, ?, ?) ";
	
	private final String UPDATE = "UPDATE equipamentos SET descricao_curta = ?, "
			+ "especificacoes = ?, garantia = ?, status = ? WHERE id = ? ";
	
	private final String DELETE = "DELETE FROM equipamentos WHERE id = ? ";
	
	private final String SELECT_BY_ID = "SELECT id, descricao_curta, especificacoes, "
			+ "garantia, status FROM equipamentos WHERE id = ? ";
	
	private final String SELECT_BY_DESC = "SELECT id, descricao_curta, especificacoes, "
			+ "garantia, status FROM equipamentos WHERE Upper(descricao_curta) LIKE Upper(?) ";
	
	private Connection conexao;
	
	public DaoPostgresqlEquipamento() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	@Override
	public void inserir(Equipamento equipamento) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setString(1, equipamento.getDescricaoCurta());
			ps.setString(2, equipamento.getEspecificacoes());
			ps.setInt(3, equipamento.getGarantia());
			ps.setString(4, equipamento.getStatus().name());
			ps.execute();
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "inserir o equipamento. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public void alterar(Equipamento equipamento) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);			
			ps = conexao.prepareStatement(UPDATE);
			ps.setString(1, equipamento.getDescricaoCurta());
			ps.setString(2, equipamento.getEspecificacoes());
			ps.setInt(3, equipamento.getGarantia());
			ps.setString(4, equipamento.getStatus().name());
			ps.setInt(5, equipamento.getId());
			boolean isAlteracaoOK = ps.executeUpdate() == 1;
			if (isAlteracaoOK) {
				this.conexao.commit();
			}else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "alterar o equipamento. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public void excluirPor(int id) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			ps = conexao.prepareStatement(DELETE);
			ps.setInt(1, id);
			boolean isExclusaoOK = ps.executeUpdate() == 1;
			if (isExclusaoOK) {
				this.conexao.commit();				
			}else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "excluir o equipamento. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
		}		
	}

	@Override
	public Equipamento buscarPor(int id) {		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return extrairDo(rs);
			}
			return null;
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "buscar o equipamento. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}

	@Override
	public List<Equipamento> listarPor(String descricaoCurta) { 
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_DESC);
			ps.setString(1, descricaoCurta);
			rs = ps.executeQuery();
			while (rs.next()) {
				equipamentos.add(extrairDo(rs));
			}
			return equipamentos;
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "listar os equipamentos. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
	
	private Equipamento extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String descricaoCurta = rs.getString("descricao_curta");
			String especificacoes = rs.getString("especificacoes");
			int garantia = rs.getInt("garantia");
			Status status = Status.valueOf(rs.getString("status"));			
			return new Equipamento(id, descricaoCurta, especificacoes, garantia, status);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "extrair o contato. Motivo: " + e.getMessage());
		}
	}

}
