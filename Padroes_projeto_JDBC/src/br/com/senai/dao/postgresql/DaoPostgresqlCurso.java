package br.com.senai.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.dao.DaoCurso;
import br.com.senai.dao.ManagerDB;
import br.com.senai.domain.Curso;

public class DaoPostgresqlCurso implements DaoCurso{

	private final String INSERT = "INSERT INTO cursos (descricao_curta) VALUES (?)";
	
	private final String UPDATE = "UPDATE cursos SET descricao_curta = ? WHERE id = ?";
	
	private final String DELETE = "DELETE FROM cursos WHERE id = ?";
	
	private final String SELECT_BY_ID = "SELECT id, descricao_curta FROM cursos WHERE id = ?";
	
	private final String SELECT_BY_DESC = "SELECT id, descricao_curta FROM cursos WHERE Upper(descricao_curta) LIKE Upper(?)";
	
	@Override
	public void inserir(Curso curso) {
		
		Connection conexao = ManagerDB.getInstance().getConexao();
		PreparedStatement psInsert = null;
		try {
			psInsert = conexao.prepareStatement(INSERT);
			psInsert.setString(1, curso.getDescricaoCurta());
			psInsert.execute();
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na inserção do curso. Motivo: " + e.getMessage());
		}finally {
			ManagerDB.getInstance().fechar(psInsert);
		}
		
	}

	@Override
	public void alterar(Curso curso) {
		
		Connection conexao = ManagerDB.getInstance().getConexao();
		PreparedStatement psUpdate = null;
		try {
			ManagerDB.getInstance().configurarAutoCommit(conexao, false);
			psUpdate = conexao.prepareStatement(UPDATE);
			psUpdate.setString(1, curso.getDescricaoCurta());
			psUpdate.setInt(2, curso.getId());
			boolean isUpdateOk = psUpdate.executeUpdate() == 1;
			if (isUpdateOk) {
				conexao.commit();
			}else {
				conexao.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na alteração do curso. Motivo: " + e.getMessage());
		}finally {
			ManagerDB.getInstance().fechar(psUpdate);
		}
		
	}

	@Override
	public void excluir(int id) {
		
		Connection conexao = ManagerDB.getInstance().getConexao();
		PreparedStatement psDelete = null;
		try {
			ManagerDB.getInstance().configurarAutoCommit(conexao, false);
			psDelete = conexao.prepareStatement(DELETE);
			psDelete.setInt(1, id);
			boolean isDeleteOk = psDelete.executeUpdate() == 1;
			if (isDeleteOk) {
				conexao.commit();
			}else {
				conexao.rollback();
			}
			ManagerDB.getInstance().fechar(psDelete);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao excluir curso. Motivo: " + e.getMessage());
		}finally {
			ManagerDB.getInstance().fechar(psDelete);
		}
		
	}

	@Override
	public Curso buscarPor(int id) {
		
		Connection conexao = ManagerDB.getInstance().getConexao();
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
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na busca do curso. Motivo: " + e.getMessage());
		}finally {
			ManagerDB.getInstance().fechar(psSelect);
			ManagerDB.getInstance().fechar(rsSelect);
		}
		
		return null;
	}

	@Override
	public List<Curso> listarPor(String descricaoCurta) {
		
		Connection conexao = ManagerDB.getInstance().getConexao();
		PreparedStatement psSelect = null;
		ResultSet rs = null;
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			psSelect = conexao.prepareStatement(SELECT_BY_DESC);
			psSelect.setString(1, "%" + descricaoCurta);
			rs = psSelect.executeQuery();
			while(rs.next()) {
				Curso cursoEncontrado = extrairCursoDo(rs);
				cursos.add(cursoEncontrado);
			}
				
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro nao listagem. Motivo: " + e.getMessage());
		}finally {
			ManagerDB.getInstance().fechar(psSelect);
			ManagerDB.getInstance().fechar(rs);
		}
		
		return cursos;
	}

	private Curso extrairCursoDo(ResultSet rs) {
		
		try {
			int id = rs.getInt("id");
			String descricaoCurta = rs.getString("descricao_curta");
			return new Curso(id, descricaoCurta);
			
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na extração do curso. Motivo: " + e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
