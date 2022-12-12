package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Usuario;

public class UsuariosTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
	
	public UsuariosTableModel(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		if(columnIndex == 0) {
			return "Login";
		} 
		throw new IllegalArgumentException("Índice inválido");
	}

	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario usuarioDaLinha = usuarios.get(rowIndex);
		if (columnIndex == 0) {
			return usuarioDaLinha.getLogin();
		} throw new IllegalArgumentException("Índice inválido.");
	}
	
	public Usuario getPor(int rowIndex) {
		return usuarios.get(rowIndex);
	}
	
	public void removePor(int rowIndex) {
		this.usuarios.remove(rowIndex);
	}

}
