package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class tlCadastroCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpNomeCliente;
	private JTextField cpIdadeCliente;
	private JTextField cpCPF;
	private JTextField cpEnderecoCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tlCadastroCliente frame = new tlCadastroCliente(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tlCadastroCliente(ArrayList<Cliente> clientes) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTelaCadastro = new JLabel("Tela de Cadastro de Cliente");
		lblTelaCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaCadastro.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
		
		JLabel lblNomeCliente = new JLabel("Nome:");
		lblNomeCliente.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
		
		cpNomeCliente = new JTextField();
		cpNomeCliente.setColumns(10);
		
		JLabel lblIdadeCliente = new JLabel("Idade:");
		lblIdadeCliente.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
		
		cpIdadeCliente = new JTextField();
		cpIdadeCliente.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
		
		cpCPF = new JTextField();
		cpCPF.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
		
		cpEnderecoCliente = new JTextField();
		cpEnderecoCliente.setColumns(10);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente();
				
				String nome = cpNomeCliente.getText();
				Integer idade = Integer.parseInt(cpIdadeCliente.getText());
				String cpf = cpCPF.getText();
				String endereco = cpEnderecoCliente.getText();
				clientes.add(cliente.cadastrar(nome, idade, cpf, endereco));
				JOptionPane.showMessageDialog(null, "cliente cadastrado com sucesso!!");
				
				cpNomeCliente.setText("");
				cpIdadeCliente.setText("");
				cpCPF.setText("");
				cpEnderecoCliente.setText("");
				
			}
		});
		btnCadastrarCliente.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCadastrarCliente.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTelaCadastro, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeCliente)
								.addComponent(lblIdadeCliente, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereco))
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cpEnderecoCliente, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpCPF, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpIdadeCliente, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpNomeCliente, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnCadastrarCliente))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTelaCadastro)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomeCliente)
						.addComponent(cpNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdadeCliente, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpIdadeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEndereco, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpEnderecoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(btnCadastrarCliente)
					.addContainerGap(113, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
