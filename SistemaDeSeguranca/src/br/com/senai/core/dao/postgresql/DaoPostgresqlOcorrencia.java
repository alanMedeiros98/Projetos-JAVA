package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoOcorrencia;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Colaborador;
import br.com.senai.core.domain.Envolvido;
import br.com.senai.core.domain.Incidente;
import br.com.senai.core.domain.Ocorrencia;

public class DaoPostgresqlOcorrencia implements DaoOcorrencia {

	private final String INSERT = "INSERT INTO ocorrencias (data, detalhamento, "
			+ " id_incidente, id_envolvido, id_colaborador)"
			+ " VALUES (?, ?, ?, ?, ?)";	
	
	private final String UPDATE = "UPDATE ocorrencias SET "
			+ " data = ?, "
			+ " detalhamento = ?, "
			+ " id_incidente = ?, "
			+ " id_envolvido = ?, "
			+ " id_colaborador = ? "
			+ " WHERE id = ? ";
	
	private final String DELETE = "DELETE FROM ocorrencias WHERE id = ? ";
	
	private final String SELECT_BY_ID = "SELECT ocorrencias.id, "
			+ " envolvidos.nome,"
			+ " incidentes.descricao_curta "
			+ " FROM ocorrencias ,"
			+ "     envolvidos, " 
			+ "     incidentes"
			+ " WHERE ocorrencias.id_envolvido = envolvidos.id AND"
			+ " ocorrencias.id_incidente = incidentes.id AND"
			+ " ocorrencias.id_envolvido = envolvidos.id";
	
	private final String SELECT_BY_DESC = "SELECT o.id, o.data, o.detalhamento, o.id_incidente, " +  
		       "o.id_envolvido, o.id_colaborador, e.nome, i.descricao_curta, c.nome_completo " +
		       "FROM envolvidos e, " + 
		       "     ocorrencias o, " +  
		       "     colaboradores c, " +  
		       "     incidentes i " + 
		       "WHERE e.id = o.id_envolvido " + 
		       "AND c.id = o.id_colaborador " + 
		       "AND i.id = o.id_incidente " +
		       "AND Upper(e.nome) LIKE Upper(?)";
	
	private Connection conexao;
	
	public DaoPostgresqlOcorrencia() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}


	@Override
	public void inserir(Ocorrencia ocorrencia) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setDate(1, Date.valueOf(ocorrencia.getData()));
			ps.setString(2, ocorrencia.getDetalhamento());
			ps.setInt(3, ocorrencia.getIncidente().getId());
			ps.setInt(4, ocorrencia.getEnvolvido().getId());
			ps.setInt(5, ocorrencia.getColaborador().getId());
			ps.execute();
		
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro na inserção"
					+ " da ocorrência. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
	}

	@Override
	public void alterar(Ocorrencia ocorrencia) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, false);
			ps = conexao.prepareStatement(UPDATE);
			ps.setDate(1, Date.valueOf(ocorrencia.getData()));
			ps.setString(2, ocorrencia.getDetalhamento());
			ps.setInt(3, ocorrencia.getIncidente().getId());
			ps.setInt(4, ocorrencia.getEnvolvido().getId());
			ps.setInt(5, ocorrencia.getColaborador().getId());
			ps.setInt(6, ocorrencia.getId());
			
			boolean isAlteracaoOK = ps.executeUpdate() == 1;
			if (isAlteracaoOK) {
				this.conexao.commit();
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, true);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro na edição"
					+ " da ocorrencia. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
	}

	@Override
	public void excluirPor(int id) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, false);
			ps = conexao.prepareStatement(DELETE);
			ps.setInt(1, id);
			boolean isExclusaoOK = ps.executeUpdate() == 1;
			if (isExclusaoOK) {
				this.conexao.commit();
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, true);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro "
					+ " ao excluir a ocorrencia. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
	}

	@Override
	public Ocorrencia buscarPor(int id) {
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
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao buscar"
					+ " a ocorrencia. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		
	}

	@Override
	public List<Ocorrencia> listarPor(String ocorrencia) {
		List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_DESC);
			ps.setString(1, ocorrencia);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				ocorrencias.add(extrairDo(rs));
			}
			return ocorrencias;
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao listar"
					+ " a ocorrencia. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
	
	private Ocorrencia extrairDo(ResultSet rs) {
		try {
			
			int id = rs.getInt("id");
			LocalDate data = rs.getDate("data").toLocalDate();
			String detalhamento = rs.getString("detalhamento");
			
			int idEnvolvido = rs.getInt("id_envolvido");
			String nome = rs.getString("nome");
			
			int idIncidente = rs.getInt("id_incidente");
			String descricao = rs.getString("descricao_curta");
			
			int idColaborador = rs.getInt("id_colaborador");
			String nomeCompleto = rs.getString("nome_completo");
			
			Envolvido envolvido = new Envolvido(idEnvolvido, nome);
			Incidente incidente = new Incidente(idIncidente, descricao);
			Colaborador colaborador = new Colaborador(idColaborador, nomeCompleto);
			
			return new Ocorrencia(id, data, detalhamento, envolvido, incidente, colaborador);			

		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "extrair a ocorrencia. Motivo: " + ex.getMessage());
		}

	}
	
	

}
