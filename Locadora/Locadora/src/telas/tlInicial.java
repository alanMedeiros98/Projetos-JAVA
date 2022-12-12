package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Cliente;

import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class tlInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tlInicial frame = new tlInicial(null);
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
	public tlInicial(ArrayList<Cliente> clientes) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTelaInicial = new JLabel("Tela Inicial gerenciamento de locadora");
		lblTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaInicial.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
		
		JButton btnCadCliente = new JButton("Cadastrar Cliente");
		btnCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tlCadastroCliente telaCliente = new tlCadastroCliente(clientes);
				telaCliente.setVisible(true);
			}
		});
		btnCadCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnAltCliente = new JButton("Alterar Cliente");
		btnAltCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnRemCliente = new JButton("Remover Cliente");
		btnRemCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnCadFilme = new JButton("Cadastrar Filme");
		btnCadFilme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnLocFilme = new JButton("Localização Filme");
		btnLocFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLocFilme.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnRemFilme = new JButton("Remover Filme");
		btnRemFilme.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnAlugFilme = new JButton("Alugar Filme");
		btnAlugFilme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDevFilme = new JButton("Devolver Filme");
		btnDevFilme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnRelatrios = new JButton("Relatórios");
		btnRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tlRelatorio telaRelatorio = new tlRelatorio(clientes);
				telaRelatorio.setVisible(true);
			}
		});
		btnRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnCadCliente)
									.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
									.addComponent(btnCadFilme, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTelaInicial, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAltCliente, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
									.addComponent(btnLocFilme, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRemCliente, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
									.addComponent(btnRemFilme, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(192)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnDevFilme, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
									.addComponent(btnRelatrios, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAlugFilme, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblTelaInicial, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadCliente)
							.addGap(18)
							.addComponent(btnAltCliente, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRemCliente, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadFilme, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLocFilme, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRemFilme, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnAlugFilme, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDevFilme, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRelatrios, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
