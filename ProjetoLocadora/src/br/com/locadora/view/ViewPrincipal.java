package br.com.locadora.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal frame = new ViewPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewPrincipal() {
		setTitle("Tela Principal Locadora");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 604, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu Pricipal");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMenu.setBounds(178, 11, 239, 63);
		contentPane.add(lblMenu);
		
		JButton btnCadastroCliente = new JButton("Cadastro Clientes");
		btnCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastroCliente.setBounds(48, 95, 175, 68);
		contentPane.add(btnCadastroCliente);
		
		JButton btnCadastroFilmes = new JButton("Cadastro Filmes");
		btnCadastroFilmes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastroFilmes.setBounds(48, 188, 175, 68);
		contentPane.add(btnCadastroFilmes);
	}
}
