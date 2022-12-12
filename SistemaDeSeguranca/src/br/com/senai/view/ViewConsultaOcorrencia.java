package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Ocorrencia;
import br.com.senai.core.service.OcorrenciaService;
import br.com.senai.view.componentes.table.OcorrenciaTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ViewConsultaOcorrencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtFiltro;
	private OcorrenciaService service;
	private JTable tableOcorrencia;

	public ViewConsultaOcorrencia() {
		this.service = new OcorrenciaService();
		OcorrenciaTableModel model = new OcorrenciaTableModel(new ArrayList<Ocorrencia>());
		this.tableOcorrencia = new JTable(model);
		tableOcorrencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setResizable(false);
		setTitle("Gerenciar Ocorr\u00EAncia - Listagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFiltro = new JLabel("Filtro*");
		lblFiltro.setBounds(12, 57, 55, 16);
		contentPane.add(lblFiltro);

		edtFiltro = new JTextField();
		edtFiltro.setBounds(12, 74, 232, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);

		JLabel lblResultado = new JLabel("Resultados");
		lblResultado.setBounds(12, 114, 69, 16);
		contentPane.add(lblResultado);

		JScrollPane scrollPane = new JScrollPane(tableOcorrencia);
		scrollPane.setBounds(12, 130, 410, 192);
		contentPane.add(scrollPane);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableOcorrencia.getSelectedRow();

				if (linhaSelecionada >= 0) {

					int opcao = JOptionPane.showConfirmDialog(contentPane, "Deseja remover a ocorrência?", "Remoção",
							JOptionPane.YES_NO_OPTION);

					if (opcao == 0) {
						OcorrenciaTableModel model = (OcorrenciaTableModel) tableOcorrencia.getModel();
						Ocorrencia ocorrenciaSelecionada = model.getPor(linhaSelecionada);
						try {
							service.excluirPor(ocorrenciaSelecionada.getId());
							model.removerPor(linhaSelecionada);
							tableOcorrencia.updateUI();
							JOptionPane.showMessageDialog(contentPane, "Ocorrência removida com sucesso");
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(contentPane, e2.getMessage());
						}
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha");
				}

			}
		});
		btnRemover.setBounds(324, 333, 98, 26);
		contentPane.add(btnRemover);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableOcorrencia.getSelectedRow();
				if (linhaSelecionada >= 0) {
					OcorrenciaTableModel model = (OcorrenciaTableModel) tableOcorrencia.getModel();
					Ocorrencia ocorrenciaSelecionada = model.getPor(linhaSelecionada);
					ViewCadastroOcorrencia view = new ViewCadastroOcorrencia();
					view.setOcorrencia(ocorrenciaSelecionada);
					view.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para edição.");
				}

			}
		});
		btnEditar.setBounds(223, 333, 98, 26);
		contentPane.add(btnEditar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String filtroInformado = edtFiltro.getText();
					List<Ocorrencia> ocorrenciaEncontrada = service.listarPor(filtroInformado);
					if (ocorrenciaEncontrada.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Não foi encontrado nenhum envolvido vinculado a uma "
								+ "ocorrência com essa descrição");
					}
					OcorrenciaTableModel model = new OcorrenciaTableModel(ocorrenciaEncontrada);
					tableOcorrencia.setModel(model);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnListar.setBounds(256, 71, 98, 26);
		contentPane.add(btnListar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroOcorrencia view = new ViewCadastroOcorrencia();
				view.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(324, 13, 98, 26);
		contentPane.add(btnAdicionar);

		setLocationRelativeTo(null);
	}
}
