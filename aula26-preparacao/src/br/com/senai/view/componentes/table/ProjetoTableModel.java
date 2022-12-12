package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Projeto;

public class ProjetoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private List<Projeto> projetos;
	
	public ProjetoTableModel(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	@Override
	public int getRowCount() {
		return projetos.size();
	}

	@Override
	public int getColumnCount() {		
		return 2;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ID";
		}else if (columnIndex == 1) {
			return "Descrição Curta";
		}
		throw new IllegalArgumentException("Índice inválido");
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Projeto projetoDaLinha = projetos.get(rowIndex);
		if (columnIndex == 0) {
			return projetoDaLinha.getId();
		}else if (columnIndex == 1) {
			return projetoDaLinha.getDescricaoCurta();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
	public Projeto getPor(int rowIndex) {
		return this.projetos.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		this.projetos.remove(rowIndex);
	}

}
