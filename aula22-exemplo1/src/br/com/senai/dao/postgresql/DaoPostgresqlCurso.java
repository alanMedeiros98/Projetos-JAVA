package br.com.senai.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.dao.DaoCurso;
import br.com.senai.dao.ManagerDb;
import br.com.senai.domain.Curso;

public class DaoPostgresqlCurso implements DaoCurso{

	private final String INSERT = "INSERT INTO cursos (descricao_curta) "
			+ "VALUES (?)";
	
	private final String UPDATE = "UPDATE cursos SET descricao_curta = ? "
			+ "WHERE id = ?";
	
	private final String DELETE = "DELETE FROM cursos WHERE id = ?";
	
	private final String SELECT_BY_ID = "SELECT id, descricao_curta "
			+ "FROM cursos WHERE id = ?";
	
	private final String SELECT_BY_DESC = "SELECT id, descricao_curta "
			+ "FROM cursos WHERE Upper(descricao_curta) LIKE Upper(?) ";
	
	@Override
	public void inserir(Curso curso) {
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psInsert = null;
		try {
			psInsert = conexao.prepareStatement(INSERT);
			psInsert.setString(1, curso.getDescricaoCurta());
			psInsert.execute();
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na inserção "
					+ "do curso. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psInsert);
		}
	}

	@Override
	public void alterar(Curso curso) {
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psUpdate = null;
		try {
			ManagerDb.getInstance().configurarAutocommit(conexao, false);
			psUpdate = conexao.prepareStatement(UPDATE);
			psUpdate.setString(1, curso.getDescricaoCurta());
			psUpdate.setInt(2, curso.getId());
			boolean isUpdateOK = psUpdate.executeUpdate() == 1;
			if (isUpdateOK) {
				conexao.commit();
			}else {
				conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommit(conexao, true);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na alteração "
					+ "do curso. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psUpdate);
		}
	}

	@Override
	public void excluirPor(int id) {
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psExcluir = null;
		try {
			ManagerDb.getInstance().configurarAutocommit(conexao, false);
			psExcluir = conexao.prepareStatement(DELETE);
			psExcluir.setInt(1, id);
			boolean isDeleteOK = psExcluir.executeUpdate() == 1;
			if (isDeleteOK) {
				conexao.commit();
			}else {
				conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommit(conexao, true);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na exclusão "
					+ "do curso. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psExcluir);
		}
	}

	@Override
	public Curso buscarPor(int id) {
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psSelect = null;
		ResultSet rsSelect = null;
		Curso cursoEncontrado = null;
		try {
			psSelect = conexao.prepareStatement(SELECT_BY_ID);
			psSelect.setInt(1, id);
			rsSelect = psSelect.executeQuery();
			if (rsSelect.next()) {
				cursoEncontrado = extrairCursoDo(rsSelect);
			}
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na busca "
					+ "do curso. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psSelect);
			ManagerDb.getInstance().fechar(rsSelect);
		}
		return cursoEncontrado;
	}

	@Override
	public List<Curso> listarPor(String descricaoCurta) {
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psSelect = null;
		ResultSet rs = null;
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			psSelect = conexao.prepareStatement(SELECT_BY_DESC);
			psSelect.setString(1, "%" + descricaoCurta + "%");
			rs = psSelect.executeQuery();
			while (rs.next()) {
				Curso cursoEncontrado = extrairCursoDo(rs);
				cursos.add(cursoEncontrado);
			}
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na listagem de cursos. "
					+ "Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psSelect);
			ManagerDb.getInstance().fechar(rs);
		}
		return cursos;
	}
	
	private Curso extrairCursoDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String descricaoCurta = rs.getString("descricao_curta");
			return new Curso(id, descricaoCurta);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na "
					+ "extração do curso. Motivo: " + e.getMessage());
		}
	}

}
