package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoProjeto;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Confirmacao;
import br.com.senai.core.domain.Projeto;
import br.com.senai.core.domain.Status;

public class DaoPostgresqlProjeto implements DaoProjeto {
	
	private final String INSERT = "INSERT INTO projetos (descricao_curta, "
			+ "detalhamento, prazo, valor, status, ativo, data_inicio, data_fim) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String UPDATE = "UPDATE projetos SET descricao_curta = ?, "
			+ "detalhamento = ?, prazo = ?, valor = ?, status = ?, ativo = ?, "
			+ "data_inicio = ?, data_fim = ? "
			+ "WHERE id = ?";
	
	private final String DELETE = "DELETE FROM projetos WHERE id = ?";
	
	private final String SELECT_BY_ID = "SELECT id, descricao_curta, "
			+ "detalhamento, prazo, valor, status, ativo, data_inicio, data_fim "
			+ "FROM projetos "
			+ "WHERE id = ? ";
	
	private final String SELECT_BY_DESC = "SELECT id, descricao_curta, "
			+ "detalhamento, prazo, valor, status, ativo, data_inicio, data_fim "
			+ "FROM projetos "
			+ "WHERE Upper(descricao_curta) LIKE Upper(?) ";
	
	private Connection conexao;
	
	public DaoPostgresqlProjeto() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}

	@Override
	public void inserir(Projeto projeto) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setString(1, projeto.getDescricaoCurta());
			ps.setString(2, projeto.getDetalhamento());
			ps.setInt(3, projeto.getPrazo());
			ps.setDouble(4, projeto.getValor());
			ps.setString(5, projeto.getStatus().name());
			ps.setString(6, projeto.getAtivo().name());
			ps.setDate(7, Date.valueOf(projeto.getDataDeInicio()));
			ps.setDate(8, Date.valueOf(projeto.getDataDeFim()));
			ps.execute();
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "inserir o projeto. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public void alterar(Projeto projeto) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);			
			ps = conexao.prepareStatement(UPDATE);
			ps.setString(1, projeto.getDescricaoCurta());
			ps.setString(2, projeto.getDetalhamento());
			ps.setInt(3, projeto.getPrazo());
			ps.setDouble(4, projeto.getValor());
			ps.setString(5, projeto.getStatus().name());
			ps.setString(6, projeto.getAtivo().name());
			ps.setDate(7, Date.valueOf(projeto.getDataDeInicio()));
			ps.setDate(8, Date.valueOf(projeto.getDataDeFim()));
			ps.setInt(9,projeto.getId());
			boolean isAlteracaoOK = ps.executeUpdate() == 1;
			if (isAlteracaoOK) {
				this.conexao.commit();
			}else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "alterar o projeto. Motivo: " + e.getMessage());
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
					+ "excluir o projeto. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}
	
	private Projeto extrairDo(ResultSet rs) {
		try {
			
			int id = rs.getInt("id");
			String descricaoCurta = rs.getString("descricao_curta");
			String detalhamento = rs.getString("detalhamento");
			int prazo = rs.getInt("prazo");
			double valor = rs.getDouble("valor");
			Status status = Status.valueOf(rs.getString("status"));
			Confirmacao ativo = Confirmacao.valueOf(rs.getString("ativo"));			
			LocalDate dataDeInicio = rs.getDate("data_inicio").toLocalDate();
			LocalDate dataDeFim = rs.getDate("data_fim").toLocalDate();
			
			return new Projeto(id, descricaoCurta, detalhamento, prazo, valor, 
					status, ativo, dataDeInicio, dataDeFim);					
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "extrair o projeto. Motivo: " + e.getMessage());
		}
	}

	@Override
	public Projeto buscarPor(int id) {
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
					+ "buscar o projeto. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}

	@Override
	public List<Projeto> listarPor(String descricaoCurta) {
		List<Projeto> projetos = new ArrayList<Projeto>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_DESC);
			ps.setString(1, descricaoCurta);
			rs = ps.executeQuery();
			while (rs.next()) {
				projetos.add(extrairDo(rs));
			}
			return projetos;
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "listar os projetos. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}		

}
