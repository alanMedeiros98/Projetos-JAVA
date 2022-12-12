package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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

import br.com.senai.core.domain.Envolvido;
import br.com.senai.core.service.EnvolvidoService;
import br.com.senai.view.componentes.table.EnvolvidosTableModel;

public class ViewConsultaEnvolvido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtFiltro;
	private EnvolvidoService service;
	private JTable tableEnvolvidos;

	public ViewConsultaEnvolvido() {
		this.service = new EnvolvidoService();
		EnvolvidosTableModel model = new EnvolvidosTableModel(new ArrayList<Envolvido>());
		this.tableEnvolvidos = new JTable(model);
		tableEnvolvidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setTitle("Gerenciar Envolvido - Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblFiltro = new JLabel("Filtro*");
		lblFiltro.setBounds(12, 54, 55, 16);
		contentPane.add(lblFiltro);

		edtFiltro = new JTextField();
		edtFiltro.setBounds(12, 72, 255, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String filtroInformado = edtFiltro.getText();
					List<Envolvido> envolvidoEncontrado = service.listarPor(filtroInformado);
					if (envolvidoEncontrado.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane,
								"Não foi encontrado nenhum envolvido com essa descrição");
					} else {
						EnvolvidosTableModel model = new EnvolvidosTableModel(envolvidoEncontrado);
						tableEnvolvidos.setModel(model);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}

			}
		});
		btnListar.setBounds(279, 69, 98, 26);
		contentPane.add(btnListar);

		JScrollPane scrollPane = new JScrollPane(tableEnvolvidos);
		scrollPane.setBounds(12, 104, 410, 109);
		contentPane.add(scrollPane);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroEnvolvido view = new ViewCadastroEnvolvido();
				view.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(324, 13, 98, 26);
		contentPane.add(btnAdicionar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int linhaSelecionada = tableEnvolvidos.getSelectedRow();
				EnvolvidosTableModel model = (EnvolvidosTableModel) tableEnvolvidos.getModel();
				if (linhaSelecionada >= 0 && !model.isVazio()) {
					int opcao = JOptionPane.showConfirmDialog(contentPane, "Deseja realmente remover?", "Remoção",
							JOptionPane.YES_NO_OPTION);

					if (opcao == 0) {
						
						Envolvido envolvidoSelecionado = model.getPor(linhaSelecionada);
						try {
							model.removerPor(linhaSelecionada);
							service.excluirPor(envolvidoSelecionado.getId());
							tableEnvolvidos.updateUI();
							JOptionPane.showMessageDialog(contentPane, "Ocorrencia removida" + " com sucesso!");
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(contentPane, ex.getMessage());
						}
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para remoção.");
				}

			}
		});
		btnRemover.setBounds(324, 222, 98, 26);
		contentPane.add(btnRemover);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableEnvolvidos.getSelectedRow();
				if (linhaSelecionada >= 0) {
					EnvolvidosTableModel model = (EnvolvidosTableModel) tableEnvolvidos.getModel();
					Envolvido envolvidoSelecionado = model.getPor(linhaSelecionada);
					ViewCadastroEnvolvido view = new ViewCadastroEnvolvido();
					view.setEnvolvido(envolvidoSelecionado);
					view.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para edição");
				}
			}

		});
		btnEditar.setBounds(214, 222, 98, 26);
		contentPane.add(btnEditar);

	}
}
