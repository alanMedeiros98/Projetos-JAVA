package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Aluno;

public class AlunoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private List<Aluno> alunos;
	
	public AlunoTableModel(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public Aluno getPor(int rowIndex) {
		return alunos.get(rowIndex);
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ID";
		}else if (columnIndex == 1) {
			return "Nome Completo";
		}else if (columnIndex == 2) {
			return "CPF";
		}
		throw new IllegalArgumentException("Indice inválido");
	}
	
	@Override
	public int getRowCount() {
		return alunos.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Aluno alunoDaLinha = alunos.get(rowIndex);
		if (columnIndex == 0) {
			return alunoDaLinha.getId();
		}else if (columnIndex == 1) {
			return alunoDaLinha.getNomeCompleto();
		}else if (columnIndex == 2) {
			return alunoDaLinha.getCpf();
		}
		throw new IllegalArgumentException("Indice inválido");
	}

}
