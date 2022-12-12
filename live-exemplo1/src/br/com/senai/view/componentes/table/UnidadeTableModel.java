package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.UnidadeCurricular;

public class UnidadeTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private List<UnidadeCurricular> unidades;
	
	public UnidadeTableModel(List<UnidadeCurricular> unidades) {
		this.unidades = unidades;
	}
	
	public void adicionar(UnidadeCurricular unidade) {
		this.unidades.add(unidade);
	}
	
	public List<UnidadeCurricular> getUnidades(){
		return unidades;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ID";
		}else if (columnIndex == 1) {
			return "Descrição";
		}
		throw new IllegalArgumentException("Indice inválido");
	}
	
	@Override
	public int getRowCount() {
		return unidades.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UnidadeCurricular unidadeDaLinha = unidades.get(rowIndex);
		if (columnIndex == 0) {
			return unidadeDaLinha.getId();					
		}else if (columnIndex == 1) {
			return unidadeDaLinha.getDescricao();
		}
		throw new IllegalArgumentException("Indice inválido");
	}

}
