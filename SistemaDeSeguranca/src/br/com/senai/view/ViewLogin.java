package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Login;
import br.com.senai.core.domain.LogsAcesso;
import br.com.senai.core.service.LoginService;
import br.com.senai.core.service.LogsService;

public class ViewLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtUsuario;
	private JPasswordField pfSenha;
	public LoginService service;
	public LogsService acessoService;

	public ViewLogin() {
		this.service = new LoginService();
		this.acessoService = new LogsService();
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBounds(12, 12, 55, 16);
		contentPane.add(lblUsuario);
		
		edtUsuario = new JTextField();
		edtUsuario.setBounds(12, 40, 410, 20);
		contentPane.add(edtUsuario);
		edtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 72, 55, 16);
		contentPane.add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(12, 100, 410, 20);
		contentPane.add(pfSenha);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String login = edtUsuario.getText();
				String senha =  new String(pfSenha.getPassword());
					
				if (login == null || senha == null) {
					JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios.");
				}	else {
					Login loginConcluido = new Login(login, senha);
					service.validar(loginConcluido);
					
					LocalDateTime dataHoraAcesso = LocalDateTime.now();

					LogsAcesso acesso = new LogsAcesso(dataHoraAcesso, loginConcluido);
					acessoService.salvar(acesso);
					
					ViewPrincipal view = new ViewPrincipal();
					view.setVisible(true);
					dispose();
					
				}	} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
				
				
			}
		});
		btnLogar.setBounds(169, 132, 98, 26);
		contentPane.add(btnLogar);
		setLocationRelativeTo(null);
	}

}
