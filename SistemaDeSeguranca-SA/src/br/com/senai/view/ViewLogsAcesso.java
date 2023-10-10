package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.LogsAcesso;
import br.com.senai.core.domain.Usuario;
import br.com.senai.core.service.LogsService;
import br.com.senai.core.service.UsuarioService;
import br.com.senai.view.componentes.table.AcessoTableModel;

public class ViewLogsAcesso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableAcessos;
	private JComboBox<Usuario> cbUsuario;
	private UsuarioService usuarioService;
	private LogsService logsService;

	public void carregarCombo() {
		List<Usuario> usuarios = usuarioService.listarTodas();
		for (Usuario u : usuarios) {
			cbUsuario.addItem(u);
		}
	}

	public ViewLogsAcesso() {
		setTitle("Logs de Acessos");
		AcessoTableModel model = new AcessoTableModel(new ArrayList<LogsAcesso>());
		this.tableAcessos = new JTable(model);
		this.logsService = new LogsService();
		this.usuarioService = new UsuarioService();
		tableAcessos.setEnabled(true);
		tableAcessos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tableAcessos.getTableHeader().setReorderingAllowed(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 31, 46, 14);
		contentPane.add(lblLogin);

		cbUsuario = new JComboBox<Usuario>();
		cbUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String usuario = cbUsuario.getSelectedItem().toString();
					List<LogsAcesso> logs = logsService.listarAcessos(usuario);
					AcessoTableModel model = new AcessoTableModel(logs);
					tableAcessos.setModel(model);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		cbUsuario.setBounds(10, 45, 275, 22);
		contentPane.add(cbUsuario);

		JLabel lblAcessos = new JLabel("Acessos");
		lblAcessos.setBounds(10, 86, 82, 14);
		contentPane.add(lblAcessos);

		JScrollPane spAcessos = new JScrollPane(tableAcessos);
		spAcessos.setBounds(10, 101, 414, 149);
		contentPane.add(spAcessos);

		this.carregarCombo();

	}

}
