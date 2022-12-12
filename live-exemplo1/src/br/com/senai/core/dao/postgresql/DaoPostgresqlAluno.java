package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoAluno;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Aluno;

public class DaoPostgresqlAluno implements DaoAluno {

	private final String SELECT_BY_NOME = "SELECT a.id, a.nome_completo, a.cpf "
			+ "FROM alunos a "
			+ "WHERE Upper(a.nome_completo) LIKE Upper(?)";
	
	private Connection conexao;
	
	public DaoPostgresqlAluno() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	@Override
	public List<Aluno> listarPor(String nome) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_NOME);
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {
				alunos.add(extrairDo(rs));
			}
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao listar os alunos. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		return alunos;
	}
	
	private Aluno extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String nomeCompleto = rs.getString("nome_completo");
			String cpf = rs.getString("cpf");
			return new Aluno(id, nomeCompleto, cpf);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao extrair o aluno. Motivo: " + e.getMessage());
		}
	}
	
}
