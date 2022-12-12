package br.com.senai.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Ativo;
import br.com.senai.core.domain.Usuario;
import br.com.senai.core.service.UsuarioService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtLogin;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmSenha;
	private UsuarioService usuarioService;
	private Usuario usuario;
	private JCheckBox chkAtivo;
	

	public ViewCadastroUsuario() {
		this.usuarioService = new UsuarioService();
		setTitle("Gerenciar Usu\u00E1rios - Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(12, 43, 55, 16);
		contentPane.add(lblLogin);
		
		edtLogin = new JTextField();
		edtLogin.setBounds(12, 69, 410, 20);
		contentPane.add(edtLogin);
		edtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 101, 55, 16);
		contentPane.add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(12, 129, 410, 20);
		contentPane.add(pfSenha);
		
		JLabel lblConfirmSenha = new JLabel("Confirma\u00E7\u00E3o de Senha");
		lblConfirmSenha.setBounds(12, 161, 150, 16);
		contentPane.add(lblConfirmSenha);
		
		pfConfirmSenha = new JPasswordField();
		pfConfirmSenha.setBounds(12, 189, 410, 20);
		contentPane.add(pfConfirmSenha);
		
		chkAtivo = new JCheckBox("Ativo");
		chkAtivo.setBounds(8, 217, 112, 24);
		contentPane.add(chkAtivo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String login = edtLogin.getText();
					String senha = new String(pfSenha.getPassword());
					String confirmacao = new String(pfConfirmSenha.getPassword());
					Ativo ativo = chkAtivo.isSelected() ? Ativo.S : Ativo.N;
					if (login.isEmpty() || senha.isEmpty() || confirmacao.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios.");
					} else {
					if (usuario == null) {
						usuario = new Usuario(login, senha, confirmacao, ativo);
						usuarioService.salvar(usuario);
						JOptionPane.showMessageDialog(contentPane, "Usuario inserida com sucesso!");
					} else {
						usuario.setLogin(login);
						usuario.setSenha(senha);
						usuario.setConfirmacaoSenha(confirmacao);
						usuarioService.salvar(usuario);
						JOptionPane.showMessageDialog(contentPane, "Usuário alterado com sucesso!");
					}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
					usuario = null;
				}
			}
		});
		btnSalvar.setBounds(324, 223, 98, 26);
		contentPane.add(btnSalvar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaUsuario view = new ViewConsultaUsuario();
				view.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(324, 12, 98, 26);
		contentPane.add(btnConsultar);
		setLocationRelativeTo(null);
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		this.edtLogin.setText(usuario.getLogin());
		this.pfSenha.setText(usuario.getSenha());
		this.pfConfirmSenha.setText(usuario.getConfirmacaoSenha());
		this.chkAtivo.setSelected(usuario.getAtivo() == Ativo.S);
	}
}
