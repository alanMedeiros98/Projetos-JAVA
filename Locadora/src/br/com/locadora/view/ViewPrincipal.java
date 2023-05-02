package br.com.locadora.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.locadora.core.domain.Cliente;

public class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewPrincipal(ArrayList<Cliente> clientes) {
		setTitle("Gest\u00E3o de Locadora");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTelaInicial = new JLabel("Tela Inicial gerenciamento de locadora");
		lblTelaInicial.setBounds(17, 58, 562, 43);
		lblTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaInicial.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
		
		JButton btnCadCliente = new JButton("Cadastrar Cliente");
		btnCadCliente.setBounds(17, 113, 188, 35);
		btnCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroCliente telaCliente = new ViewCadastroCliente(clientes);
				telaCliente.setVisible(true);
			}
		});
		btnCadCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnAltCliente = new JButton("Alterar Cliente");
		btnAltCliente.setBounds(17, 166, 187, 33);
		btnAltCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnRemCliente = new JButton("Remover Cliente");
		btnRemCliente.setBounds(17, 217, 187, 33);
		btnRemCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnCadFilme = new JButton("Cadastrar Filme");
		btnCadFilme.setBounds(392, 113, 187, 33);
		btnCadFilme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnLocFilme = new JButton("Localizar Filme");
		btnLocFilme.setBounds(392, 164, 187, 33);
		btnLocFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLocFilme.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnRemFilme = new JButton("Remover Filme");
		btnRemFilme.setBounds(392, 215, 187, 33);
		btnRemFilme.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnAlugFilme = new JButton("Alugar Filme");
		btnAlugFilme.setBounds(197, 268, 187, 33);
		btnAlugFilme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDevFilme = new JButton("Devolver Filme");
		btnDevFilme.setBounds(197, 319, 187, 33);
		btnDevFilme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnRelatrios = new JButton("Relat\u00F3rios");
		btnRelatrios.setBounds(428, 319, 151, 33);
		btnRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewRelatorio telaRelatorio = new ViewRelatorio(clientes);
				telaRelatorio.setVisible(true);
			}
		});
		btnRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.setLayout(null);
		contentPane.add(btnCadCliente);
		contentPane.add(btnCadFilme);
		contentPane.add(lblTelaInicial);
		contentPane.add(btnAltCliente);
		contentPane.add(btnLocFilme);
		contentPane.add(btnRemCliente);
		contentPane.add(btnRemFilme);
		contentPane.add(btnDevFilme);
		contentPane.add(btnRelatrios);
		contentPane.add(btnAlugFilme);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 23);
		contentPane.add(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem miCadastro = new JMenuItem("Cadastro de Cliente");
		mnCliente.add(miCadastro);
		
		JMenuItem miAlterarCliente = new JMenuItem("Alterar Cliente");
		mnCliente.add(miAlterarCliente);
		
		JMenuItem miRemoverCliente = new JMenuItem("Remover Cliente");
		mnCliente.add(miRemoverCliente);
		
		JMenu mnFilme = new JMenu("Filme");
		menuBar.add(mnFilme);
		
		JMenuItem miCadastrarFilme = new JMenuItem("Cadastrar Filme");
		mnFilme.add(miCadastrarFilme);
		
		JMenuItem miLocalizarFilme = new JMenuItem("Localizar Filme");
		mnFilme.add(miLocalizarFilme);
		
		JMenuItem miRemoverFilme = new JMenuItem("Remover Filme");
		mnFilme.add(miRemoverFilme);
		
		JMenu mnAluguel = new JMenu("Alugar");
		menuBar.add(mnAluguel);
		
		JMenuItem miAlugarFilme = new JMenuItem("Alugar Filme");
		mnAluguel.add(miAlugarFilme);
		
		JMenuItem miDevolverFilme = new JMenuItem("Devolver Filme");
		mnAluguel.add(miDevolverFilme);
		
		JMenu mnRelatorio = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorio);
		
		JMenuItem miRelatorioFilme = new JMenuItem("Relat\u00F3rio de Filmes");
		mnRelatorio.add(miRelatorioFilme);
		
		JMenuItem miRelatorioCliente = new JMenuItem("Relat\u00F3rio de Clientes");
		mnRelatorio.add(miRelatorioCliente);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		JMenuItem miSair = new JMenuItem("Sair");
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnSair.add(miSair);
		setLocationRelativeTo(null);
	}
}
