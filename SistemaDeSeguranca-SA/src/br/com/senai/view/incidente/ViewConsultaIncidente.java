package br.com.senai.view.incidente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Incidente;
import br.com.senai.core.service.IncidenteService;
import br.com.senai.view.componentes.table.IncidentesTableModel;

public class ViewConsultaIncidente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtFiltro;
	private JTable tableIncidente;
	
	private IncidenteService service;
	

	public ViewConsultaIncidente() {
		this.service = new IncidenteService();
		IncidentesTableModel model = new IncidentesTableModel(new ArrayList<Incidente>());
		setTitle("Gerenciar Inicidentes - Listagem");
		this.tableIncidente = new JTable(model);
		tableIncidente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblFiltro = new JLabel("Filtro*");
		lblFiltro.setBounds(12, 41, 55, 16);
		contentPane.add(lblFiltro);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(12, 63, 247, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String filtroInformado = edtFiltro.getText();
					List<Incidente> incidentesEncontrados = service.listarPor(filtroInformado);
					if (incidentesEncontrados.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Não foi encontrado nenhum incidente com "
								+ " essa descrição.");
					} else {
					IncidentesTableModel model = new IncidentesTableModel(incidentesEncontrados);
					tableIncidente.setModel(model);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnListar.setBounds(271, 60, 98, 26);
		contentPane.add(btnListar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroIncidente view = new ViewCadastroIncidente();
				view.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(324, 13, 98, 26);
		contentPane.add(btnAdicionar);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(12, 89, 74, 16);
		contentPane.add(lblResultados);
		
		JScrollPane scrollPane = new JScrollPane(tableIncidente);
		scrollPane.setBounds(12, 114, 410, 121);
		contentPane.add(scrollPane);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableIncidente.getSelectedRow();
				IncidentesTableModel model = (IncidentesTableModel)tableIncidente.getModel();
				if (linhaSelecionada >= 0 && !model.isVazio()) {
					int opcao = JOptionPane.showConfirmDialog(contentPane, 
							"Deseja realmente remover!?",
							"Remoção",
							JOptionPane.YES_NO_OPTION);
				if (opcao == 0) {
					
					Incidente incidenteSelecionado = model.getPor(linhaSelecionada);
					try {
						service.excluirPor(incidenteSelecionado.getId());
						model.removerPor(linhaSelecionada);
						tableIncidente.updateUI();
						JOptionPane.showMessageDialog(contentPane, 
								"Incidente removido com sucesso!");
					}catch (IndexOutOfBoundsException iobe) {
						JOptionPane.showMessageDialog(contentPane, iobe.getMessage());
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(contentPane, ex.getMessage());
					}
				}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para remoção.");
				}
			}
		});
		btnRemover.setBounds(324, 248, 98, 26);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableIncidente.getSelectedRow();
				if (linhaSelecionada >= 0) {
					IncidentesTableModel model = (IncidentesTableModel)tableIncidente.getModel();
					Incidente incidenteSelecionado = model.getPor(linhaSelecionada);
					ViewCadastroIncidente view = new ViewCadastroIncidente();
					view.setIncidente(incidenteSelecionado);
					view.setVisible(true);
					dispose();
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para edição.");
				}
			}
		});
		btnEditar.setBounds(214, 248, 98, 26);
		contentPane.add(btnEditar);
		setLocationRelativeTo(null);
	}
}
