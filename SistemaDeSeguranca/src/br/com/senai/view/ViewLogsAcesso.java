package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.LogsAcesso;
import br.com.senai.core.domain.Usuario;
import br.com.senai.core.service.UsuarioService;
import br.com.senai.view.componentes.table.AcessoTableModel;

public class ViewLogsAcesso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableAcessos;
	private AcessoTableModel table;
	private JComboBox<Usuario> cbUsuario;
	private UsuarioService service;

	public void carregarCombo() {
		List<Usuario> usuarios = service.listarTodas();
		for (Usuario u : usuarios) {
			cbUsuario.addItem(u);
		}
	}
	public ViewLogsAcesso() {
		AcessoTableModel model = new AcessoTableModel(new ArrayList<LogsAcesso>());
		this.tableAcessos = new JTable(model);
		setTitle("Logs de Acessos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 31, 46, 14);
		contentPane.add(lblLogin);

		cbUsuario = new JComboBox<Usuario>();
		cbUsuario.setBounds(10, 45, 275, 22);
		cbUsuario.setToolTipText("Selecione");
		contentPane.add(cbUsuario);

		JLabel lblAcessos = new JLabel("Acessos");
		lblAcessos.setBounds(10, 86, 82, 14);
		contentPane.add(lblAcessos);

		JScrollPane spAcessos = new JScrollPane(tableAcessos);
		spAcessos.setBounds(10, 101, 414, 149);
		contentPane.add(spAcessos);

		tableAcessos = new JTable();
		spAcessos.setColumnHeaderView(tableAcessos);

		
		this.service = new UsuarioService();
		this.carregarCombo();
		
	}
	
	
}
