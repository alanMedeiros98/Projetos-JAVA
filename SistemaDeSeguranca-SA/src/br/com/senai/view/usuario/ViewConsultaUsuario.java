package br.com.senai.view.usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Usuario;
import br.com.senai.core.service.UsuarioService;
import br.com.senai.view.componentes.table.UsuariosTableModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ViewConsultaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtFiltro;
	private JTable tableUsuarios;
	private UsuarioService service;
	

	public ViewConsultaUsuario() {
		this.service = new UsuarioService();
		UsuariosTableModel model = new UsuariosTableModel(new ArrayList<Usuario>());
		this.tableUsuarios = new JTable(model);
		tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setResizable(false);
		setTitle("Gerenciar Usu\u00E1rios - Listagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroUsuario view = new ViewCadastroUsuario();
				view.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(254, 11, 98, 26);
		contentPane.add(btnAdicionar);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setBounds(12, 44, 55, 16);
		contentPane.add(lblFiltro);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(12, 73, 232, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String filtroInformado = edtFiltro.getText();
					List<Usuario> usuarioEncontrado = service.listarPor(filtroInformado);
					if (usuarioEncontrado.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Não foi encontrado nenhum login"
								+ " com a descrição informada.");
					} else {
						UsuariosTableModel model = new UsuariosTableModel(usuarioEncontrado);
						tableUsuarios.setModel(model);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnListar.setBounds(254, 70, 98, 26);
		contentPane.add(btnListar);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(12, 106, 79, 16);
		contentPane.add(lblResultados);
		
		JScrollPane spResultados = new JScrollPane(tableUsuarios);
		spResultados.setBounds(12, 135, 340, 91);
		contentPane.add(spResultados);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableUsuarios.getSelectedRow();
				if (linhaSelecionada >= 0) {
					UsuariosTableModel model = (UsuariosTableModel) tableUsuarios.getModel();
					Usuario  usuarioSelecionado = model.getPor(linhaSelecionada);
					ViewCadastroUsuario view = new ViewCadastroUsuario();
					view.setUsuario(usuarioSelecionado);
					view.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para edição.");
				}
				
			}
		});
		btnEditar.setBounds(266, 246, 98, 26);
		contentPane.add(btnEditar);
		setLocationRelativeTo(null);
	}
}
