package br.com.senai.view.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.domain.Ornitorrinco;

public class OrnitorrincoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	private final int QTDE_COLUNAS = 2;
	
	private List<Ornitorrinco> ornitorrincos;

	public OrnitorrincoTableModel(List<Ornitorrinco> ornitorrincos) {		
		this.ornitorrincos = ornitorrincos;
	}
	
	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		}else if (column == 1) {
			return "Nome";
		}
		throw new IllegalArgumentException("Indíce inválido");
	}
	
	public Ornitorrinco getPor(int rowIndex) {
		return ornitorrincos.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		this.ornitorrincos.remove(rowIndex);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return ornitorrincos.get(rowIndex).getId();
		}else if (columnIndex == 1) {
			return ornitorrincos.get(rowIndex).getNome();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
	@Override
	public int getRowCount() {
		return ornitorrincos.size();
	}
	
}
