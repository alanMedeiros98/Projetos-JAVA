package br.com.senai.view.componentes.table;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.LogsAcesso;

public class AcessoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<LogsAcesso> acessos;
	
	
	public AcessoTableModel(List<LogsAcesso> acesso) {
		this.acessos = acesso;
	}
	
	@Override
	public int getRowCount() {
		return acessos.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		LogsAcesso acessoDaLinha = acessos.get(rowIndex);
		if (columnIndex == 0) {
			return acessoDaLinha.getId();
		} else if (columnIndex == 1) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy - HH:mm");
			String dateFormatada = acessoDaLinha.getDataHora().format(dtf);
			return dateFormatada;
		}
		throw new IllegalArgumentException("Índice inválido.");
	}
	
	
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Código";
		} else if (columnIndex == 1) {
			return "Horário";
		}
		throw new IllegalArgumentException("Índice inválido.");
	}

}
