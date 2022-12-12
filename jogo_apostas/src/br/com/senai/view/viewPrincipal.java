package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.entity.Corrida;
import br.com.senai.service.CorridaService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewPrincipal extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public viewPrincipal() {
		setTitle("Jogo de Apostas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mundo SenaiBet399 ");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(425, 11, 493, 43);
		contentPane.add(lblNewLabel);
		
		JButton btCadastroAluno = new JButton("");
		btCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewCadastroPessoa cadPs = new viewCadastroPessoa();
				cadPs.setVisible(true);
				
			}
		});
		btCadastroAluno.setIcon(new ImageIcon(viewPrincipal.class.getResource("/br/com/senai/imagens/Pessoa.png")));
		btCadastroAluno.setForeground(Color.BLACK);
		btCadastroAluno.setBackground(Color.LIGHT_GRAY);
		btCadastroAluno.setBounds(82, 190, 81, 81);
		contentPane.add(btCadastroAluno);
		
		JButton BtCadastroCidade = new JButton("");
		BtCadastroCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCidade cidade = new ViewCidade();
				cidade.setVisible(true);
			}
		});
		BtCadastroCidade.setIcon(new ImageIcon(viewPrincipal.class.getResource("/br/com/senai/imagens/IconCidade (1).png")));
		BtCadastroCidade.setForeground(Color.BLACK);
		BtCadastroCidade.setBackground(Color.LIGHT_GRAY);
		BtCadastroCidade.setBounds(250, 190, 81, 81);
		contentPane.add(BtCadastroCidade);
		
		JButton btListaCidade = new JButton("");
		btListaCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewListaCidade listaCidade = new viewListaCidade();
				listaCidade.setVisible(true);
			}
		});
		btListaCidade.setIcon(new ImageIcon(viewPrincipal.class.getResource("/br/com/senai/imagens/IconCidade (1).png")));
		btListaCidade.setForeground(Color.BLACK);
		btListaCidade.setBackground(Color.LIGHT_GRAY);
		btListaCidade.setBounds(250, 390, 81, 81);
		contentPane.add(btListaCidade);
		
		JButton btListaPessoa = new JButton("");
		btListaPessoa.setIcon(new ImageIcon(viewPrincipal.class.getResource("/br/com/senai/imagens/relAlunos.png")));
		btListaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewListaPessoa listaPessoa = new viewListaPessoa();
				listaPessoa.setVisible(true);
			}
		});
		btListaPessoa.setForeground(Color.BLACK);
		btListaPessoa.setBackground(Color.LIGHT_GRAY);
		btListaPessoa.setBounds(82, 390, 81, 81);
		contentPane.add(btListaPessoa);
		
		JLabel lblNewLabel_1 = new JLabel("Relatório de pessoas");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(65, 365, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Relatório de cidades");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(228, 365, 119, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cadastro de pessoas");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(65, 164, 120, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Cadastro de cidades");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(228, 164, 119, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton btnCorrida = new JButton("");
		btnCorrida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CorridaService service = new CorridaService();
				Corrida corrida = new Corrida();
				
				
				String txt = "Corrida";
				
				corrida.setSequencia(txt);
				service.inserir(corrida);
				ViewCorrida telaCorrida = new ViewCorrida();
				telaCorrida.setVisible(true);
						
			}
		});
		btnCorrida.setIcon(new ImageIcon(viewPrincipal.class.getResource("/br/com/senai/imagens/Corrida.png")));
		btnCorrida.setForeground(Color.BLACK);
		btnCorrida.setBackground(Color.LIGHT_GRAY);
		btnCorrida.setBounds(904, 190, 107, 81);
		contentPane.add(btnCorrida);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Corrida");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1_2_1.setBounds(928, 164, 70, 14);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		JButton btnListaDeApostadores = new JButton("");
		btnListaDeApostadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewListaApostadores listaApostadores = new ViewListaApostadores();
				listaApostadores.setVisible(true);
			}
		});
		btnListaDeApostadores.setIcon(new ImageIcon(viewPrincipal.class.getResource("/br/com/senai/imagens/relApostadores.png")));
		btnListaDeApostadores.setForeground(Color.BLACK);
		btnListaDeApostadores.setBackground(Color.LIGHT_GRAY);
		btnListaDeApostadores.setBounds(904, 390, 107, 81);
		contentPane.add(btnListaDeApostadores);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Relatório de apostadores");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1_3.setBounds(890, 365, 140, 14);
		contentPane.add(lblNewLabel_1_1_3);
	}
}
