package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoInscricao;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Aluno;
import br.com.senai.core.domain.Inscricao;
import br.com.senai.core.domain.UnidadeCurricular;

public class DaoPostgresqlInscricao implements DaoInscricao{

	private final String INSERT = "INSERT INTO inscricoes (id_aluno, id_unidade_curricular) VALUES (?, ?)";
	
	private final String DELETE_BY_IDS = "DELETE FROM inscricoes WHERE id_aluno = ? AND id_unidade_curricular = ?";
	
	private final String SELECT_BY_ID = "SELECT i.id_unidade_curricular, uc.descricao, i.media_final,  "
			+ "i.id_aluno, a.nome_completo, a.cpf "
			+ "FROM unidades_curriculares uc, "
			+ "     inscricoes i,"
			+ "     alunos a "
			+ "WHERE i.id_unidade_curricular = uc.id "
			+ "AND i.id_aluno = a.id "
			+ "AND i.id_aluno = ?";
	
	private final String UPDATE_MEDIA = "UPDATE inscricoes SET media_final = ? "
			+ "WHERE id_unidade_curricular = ? AND id_aluno = ? ";
	
	private Connection conexao;
	
	public DaoPostgresqlInscricao() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	@Override
	public void atualizarPor(int idDoAluno, int idDaUnidade, double mediaFinal) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			ps = conexao.prepareStatement(UPDATE_MEDIA);
			ps.setDouble(1, mediaFinal);
			ps.setInt(2, idDaUnidade);
			ps.setInt(3, idDoAluno);
			boolean isAlteracaoOK = ps.executeUpdate() == 1;
			if (isAlteracaoOK) {
				this.conexao.commit();
			}else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na atualização da média. "
					+ "Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}
	
	@Override
	public void inserir(List<Inscricao> inscricoes) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			ps = conexao.prepareStatement(INSERT);
			for (Inscricao inscricao : inscricoes) {
				ps.setInt(1, inscricao.getAluno().getId());
				ps.setInt(2, inscricao.getUnidadeCurricular().getId());
				ps.execute();
			}
			this.conexao.commit();
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		}catch (Exception e) {
			ManagerDb.getInstance().realizarRollbackNa(conexao);
			throw new RuntimeException("Ocorreu um erro ao inserir as inscrições do aluno. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public void excluirPor(int idDoAluno, int idDaUnidade) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			ps = conexao.prepareStatement(DELETE_BY_IDS);
			ps.setInt(1, idDoAluno);
			ps.setInt(2, idDaUnidade);
			boolean isExclusaoOK = ps.executeUpdate() == 1;
			if (isExclusaoOK) {
				this.conexao.commit();
			}else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao remover a inscrição do aluno. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public List<Inscricao> listarPor(int idDoAluno) {
		List<Inscricao> inscricoes = new ArrayList<Inscricao>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, idDoAluno);
			rs = ps.executeQuery();
			while (rs.next()) {
				inscricoes.add(extrairDo(rs));
			}
		}catch (Exception e) {
			throw new RuntimeException("Ocorre um erro ao listar as inscrições do aluno. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		return inscricoes;
	}
	
	private Inscricao extrairDo(ResultSet rs) {
		try {
			
			int idDaUnidadeCurricular = rs.getInt("id_unidade_curricular");
			String descricao = rs.getString("descricao");
			UnidadeCurricular unidade = new UnidadeCurricular(idDaUnidadeCurricular, descricao);
			
			int idDoAluno = rs.getInt("id_aluno");
			String nomeCompleto = rs.getString("nome_completo");
			String cpf = rs.getString("cpf");
			Aluno aluno = new Aluno(idDoAluno, nomeCompleto, cpf);
			
			double mediaFinal = rs.getDouble("media_final");
			
			return new Inscricao(aluno, unidade, mediaFinal);
			
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao extrair a inscrição. Motivo: " + e.getMessage());
		}
	}

}
























