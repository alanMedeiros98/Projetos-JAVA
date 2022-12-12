package br.com.senai.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.dao.DaoPaciente;
import br.com.senai.dao.ManagerDb;
import br.com.senai.domain.Paciente;
import br.com.senai.domain.Tipo;

public class DaoPostgresqlPaciente implements DaoPaciente {

	private final String INSERT = "INSERT INTO pacientes (nome_completo, idade, tipo) VALUES (?, ?, ?)";
	
	private final String UPDATE = "UPDATE pacientes SET tipo = ? WHERE id = ?";
	
	private final String DELETE = "DELETE FROM pacientes WHERE id = ?";
	
	//private final String SELECT_BY_ID = "SELECT id, nome_completo FROM pacientes WHERE id = ?";
	
	private final String SELECT_BY_DESC = "SELECT id, nome_completo FROM pacientes WHERE Upper(nome_completo) LIKE Upper(?)";
	
	@Override
	public void inserir(Paciente paciente) {
		
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psInsert = null;
		try {
			psInsert = conexao.prepareStatement(INSERT);
			psInsert.setString(1, paciente.getNomeCompleto());
			psInsert.setInt(2, paciente.getIdade());
			psInsert.setString(3, paciente.getTipo().name());
			psInsert.execute();
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na inserção do paciente. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psInsert);
		}
		
	}

	@Override
	public void alterar(Paciente paciente) {
		
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psUpdate = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			psUpdate = conexao.prepareStatement(UPDATE);
			psUpdate.setString(1, paciente.getNomeCompleto());
			psUpdate.setInt(2, paciente.getId());
			boolean isUpdateOk = psUpdate.executeUpdate() == 1;
			if (isUpdateOk) {
				conexao.commit();
			}else {
				conexao.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na alteração do paciente. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psUpdate);
		}
		
	}

	@Override
	public List<Paciente> listarPor(String paciente) {
		
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psSelect = null;
		ResultSet rs = null;
		List<Paciente> pacientes = new ArrayList<Paciente>();
		try {
			psSelect = conexao.prepareStatement(SELECT_BY_DESC);
			psSelect.setString(1, "%" + paciente);
			rs = psSelect.executeQuery();
			while(rs.next()) {
				Paciente pacienteEncontrado = extrairPacienteDo(rs);
				pacientes.add(pacienteEncontrado);
			}
				
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro nao listagem. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psSelect);
			ManagerDb.getInstance().fechar(rs);
		}
		
		return pacientes;
	}

	@Override
	public void excluir(int id) {
		
		Connection conexao = ManagerDb.getInstance().getConexao();
		PreparedStatement psDelete = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			psDelete = conexao.prepareStatement(DELETE);
			psDelete.setInt(1, id);
			boolean isDeleteOk = psDelete.executeUpdate() == 1;
			if (isDeleteOk) {
				conexao.commit();
			}else {
				conexao.rollback();
			}
			ManagerDb.getInstance().fechar(psDelete);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao excluir paciente. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(psDelete);
		}
		
	}

	
	private Paciente extrairPacienteDo(ResultSet rs) {
			
			try {
				int id = rs.getInt("id");
				String nome_Completo = rs.getString("nome_completo");
				int idade = rs.getInt("idade");
				Tipo tipo = Tipo.valueOf(rs.getString("tipo"));
				return new Paciente(nome_Completo, idade, tipo);
				
			} catch (Exception e) {
				throw new RuntimeException("Ocorreu um erro na extração do paciente. Motivo: " + e.getMessage());
			}
			
		}

}
