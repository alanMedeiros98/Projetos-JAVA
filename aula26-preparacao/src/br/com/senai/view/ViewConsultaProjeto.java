package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Projeto;
import br.com.senai.core.service.ProjetoService;
import br.com.senai.view.componentes.table.ProjetoTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewConsultaProjeto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private ProjetoService service;
	
	private JTable tableProjeto;
	private JTextField edtFiltro;

	/**
	 * Create the frame.
	 */
	public ViewConsultaProjeto() {
		this.service = new ProjetoService();
		ProjetoTableModel model = new ProjetoTableModel(new ArrayList<Projeto>());
		this.tableProjeto = new JTable(model);		
		setResizable(false);
		setTitle("Gerenciar Projetos - Listagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Filtro");
		lblNewLabel.setBounds(12, 40, 55, 16);
		contentPane.add(lblNewLabel);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(12, 68, 300, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String filtroInformado = edtFiltro.getText();
					List<Projeto> projetosEncontrados = service.listarPor(filtroInformado);
					ProjetoTableModel model = new ProjetoTableModel(projetosEncontrados);
					tableProjeto.setModel(model);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}				
			}
		});
		btnListar.setBounds(324, 65, 98, 26);
		contentPane.add(btnListar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroProjeto view = new ViewCadastroProjeto();
				view.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(324, 12, 98, 26);
		contentPane.add(btnAdicionar);
		
		JScrollPane spProjetos = new JScrollPane(tableProjeto);
		spProjetos.setBounds(12, 126, 410, 195);
		contentPane.add(spProjetos);
		
		JLabel lblNewLabel_1 = new JLabel("Resultados");
		lblNewLabel_1.setBounds(12, 100, 98, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableProjeto.getSelectedRow();
				if (linhaSelecionada >= 0) {
					
					int opcao = JOptionPane.showConfirmDialog(contentPane, 
							"Deseja remover o registro selecionado?", 
							"Remoção", JOptionPane.YES_NO_OPTION);
					
					if (opcao == 0) {
						ProjetoTableModel model = (ProjetoTableModel)tableProjeto.getModel();
						Projeto projetoSelecionado = model.getPor(linhaSelecionada);
						try {
							model.removerPor(linhaSelecionada);
							service.removerPor(projetoSelecionado.getId());
							tableProjeto.updateUI();
							JOptionPane.showMessageDialog(contentPane, 
									"Projeto removido com sucesso");
						}catch (Exception ex) {
							JOptionPane.showMessageDialog(contentPane, ex.getMessage());
						}
						
					}
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para exclusão");
				}
			}
		});
		btnRemover.setBounds(324, 333, 98, 26);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableProjeto.getSelectedRow();
				if (linhaSelecionada >= 0) {
					ProjetoTableModel model = (ProjetoTableModel)tableProjeto.getModel();
					Projeto projetoSelecionado = model.getPor(linhaSelecionada);
					ViewCadastroProjeto view = new ViewCadastroProjeto();
					view.setProjeto(projetoSelecionado);
					view.setVisible(true);
					dispose();					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para edição");
				}
			}
		});
		btnEditar.setBounds(214, 333, 98, 26);
		contentPane.add(btnEditar);
	}
}
