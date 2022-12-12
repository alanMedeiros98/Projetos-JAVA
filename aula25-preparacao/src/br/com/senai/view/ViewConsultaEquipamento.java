package br.com.senai.view;

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
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Equipamento;
import br.com.senai.core.service.EquipamentoService;
import br.com.senai.view.componentes.table.EquipamentoTableModel;

public class ViewConsultaEquipamento extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextField edtFiltro;
	
	private JTable tableEquipamentos;
	
	private JScrollPane spTable;
	
	private EquipamentoService service;	

	/**
	 * Create the frame.
	 */
	public ViewConsultaEquipamento() {
		setResizable(false);
		setTitle("Gerenciar Equipamentos - Consulta");
		setName("frmConsulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.service = new EquipamentoService();
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroEquipamento view = new ViewCadastroEquipamento();
				view.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(335, 11, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableEquipamentos.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int opcao = JOptionPane.showConfirmDialog(contentPane, 
							"Deseja remover o registro selecionado?", "Remoção", JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						EquipamentoTableModel model = (EquipamentoTableModel)tableEquipamentos.getModel();
						Equipamento equipamentoSelecionado = model.getPor(linhaSelecionada);
						try {
							service.removerPor(equipamentoSelecionado.getId());
							model.removerPor(linhaSelecionada);
							tableEquipamentos.updateUI();
							JOptionPane.showMessageDialog(contentPane, "Equipamento removido com sucesso");
						}catch (Exception ex) {
							JOptionPane.showMessageDialog(contentPane, ex.getMessage());
						}						
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para remoção");
				}
			}
		});
		btnRemover.setBounds(335, 324, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableEquipamentos.getSelectedRow();
				if (linhaSelecionada >= 0) {					
					EquipamentoTableModel model = (EquipamentoTableModel)tableEquipamentos.getModel();
					Equipamento equipamentoSelecionado = model.getPor(linhaSelecionada);					
					ViewCadastroEquipamento view = new ViewCadastroEquipamento();
					view.setEquipamento(equipamentoSelecionado);
					view.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para edição");
				}
			}
		});
		btnEditar.setBounds(236, 324, 89, 23);
		contentPane.add(btnEditar);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setBounds(10, 38, 55, 16);
		contentPane.add(lblFiltro);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(10, 65, 315, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
						
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Equipamento> equipamentos = service.listarPor(edtFiltro.getText());
					EquipamentoTableModel model = new EquipamentoTableModel(equipamentos);
					tableEquipamentos.setModel(model);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnListar.setBounds(335, 62, 89, 23);
		contentPane.add(btnListar);
		
		EquipamentoTableModel model = new EquipamentoTableModel(new ArrayList<Equipamento>());
		tableEquipamentos = new JTable(model);
		spTable = new JScrollPane(tableEquipamentos);
		spTable.setBounds(10, 128, 414, 187);
		contentPane.add(spTable);				
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(10, 101, 105, 16);
		contentPane.add(lblResultados);
	}

}
