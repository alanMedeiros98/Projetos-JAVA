package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Inscricao;

public class InscricaoTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private List<Inscricao> inscricoes;
	
	public InscricaoTableModel(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
	
	public void adicionar(Inscricao inscricao) {
		this.inscricoes.add(inscricao);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ID da Unidade";
		}else if (columnIndex == 1) {
			return "Unidade Curricular";
		}else if (columnIndex == 2) {
			return "Média Final";
		}
		throw new IllegalArgumentException("Indice inválido");
	}
	
	@Override
	public int getRowCount() {
		return inscricoes.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Inscricao inscricaoDaLinha = inscricoes.get(rowIndex);
		if (columnIndex == 0) {
			return inscricaoDaLinha.getUnidadeCurricular().getId();
		}else if (columnIndex == 1) {
			return inscricaoDaLinha.getUnidadeCurricular().getDescricao();
		}else if (columnIndex == 2) {
			return inscricaoDaLinha.getMediaFinal();
		}
		throw new IllegalArgumentException("Indice inválido");
	}

}
