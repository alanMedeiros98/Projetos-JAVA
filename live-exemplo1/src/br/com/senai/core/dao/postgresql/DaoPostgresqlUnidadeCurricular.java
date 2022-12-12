package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoUnidadeCurricular;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.UnidadeCurricular;

public class DaoPostgresqlUnidadeCurricular implements DaoUnidadeCurricular{

	private final String SELECT_TODAS = "SELECT u.id, u.descricao "
			+ "FROM unidades_curriculares u "
			+ "ORDER BY u.descricao ";
	
	private Connection conexao;
	
	public DaoPostgresqlUnidadeCurricular() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	@Override
	public List<UnidadeCurricular> listarTodas() {
		List<UnidadeCurricular> unidades = new ArrayList<UnidadeCurricular>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_TODAS);
			rs = ps.executeQuery();
			while (rs.next()) {
				unidades.add(extrairDo(rs));
			}
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na listagem de unidades. Motivo: " + e.getMessage());
		}finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		return unidades;
	}

	private UnidadeCurricular extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String descricao = rs.getString("descricao");
			return new UnidadeCurricular(id, descricao);
		}catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro na extração da unidade. Motivo: " + e.getMessage());
		}
	}
	
}
