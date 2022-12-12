package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Aluno;
import classes.DevolucaoLivro;
import classes.Livro;
import classes.AlugarLivro;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;


public class TlInicial extends JFrame {

	private JPanel contentPane;
	

	public TlInicial(ArrayList<AlugarLivro> locacoes, ArrayList<Aluno> alunos, ArrayList<Livro> livros, ArrayList<DevolucaoLivro> devolucoes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 530);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastros");
		menuBar.add(mnNewMenu);
		
		// CADASTRO ALUNO E ALTERACAO
		
		JMenu mnAluno = new JMenu("Aluno");
		mnNewMenu.add(mnAluno);
		
		JMenuItem btIncluirAluno = new JMenuItem("Incluir");
		mnAluno.add(btIncluirAluno);
		btIncluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlCadastroAlu telaaluno = new TlCadastroAlu(alunos);
				telaaluno.setVisible(true);
				
			}
		});
		btIncluirAluno.setSelected(true);
		
		JMenuItem alteracaoAlu = new JMenuItem("Altera\u00E7\u00E3o / Remo\u00E7\u00E3o");
		alteracaoAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlAlteracaoAlu telaAlteracaoAluno = new TlAlteracaoAlu(alunos);
				telaAlteracaoAluno.setVisible(true);
				
			}
		});
		mnAluno.add(alteracaoAlu);
		
		//CADASTRO LIVRO E ALTERACAO
		
		JMenu mnNewMenu_1 = new JMenu("Livro");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem btIncluirLivro = new JMenuItem("Incluir");
		mnNewMenu_1.add(btIncluirLivro);
		
		JMenuItem AlteracaoLiv = new JMenuItem("Altera\u00E7\u00E3o / Remo\u00E7\u00E3o");
		AlteracaoLiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlAlteracaoLivro telaAlteracaoLivro = new TlAlteracaoLivro(livros);
				telaAlteracaoLivro.setVisible(true);
			}
		});
		mnNewMenu_1.add(AlteracaoLiv);
		btIncluirLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlCadastroLivro telalivro = new TlCadastroLivro(livros);
				telalivro.setVisible(true);
			}
		});
		
		JMenu menurelatorios = new JMenu("Relatorios");
		menuBar.add(menurelatorios);
		
		//RELATORIO ALUNOS
		
		JMenuItem relAlunos = new JMenuItem("Alunos");
		relAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlRelatorioAluno telarelatorioAl = new TlRelatorioAluno(alunos);
				StringBuffer buffer = new StringBuffer();
				telarelatorioAl.setVisible(true);				
				
			}
			
		});
		
		menurelatorios.add(relAlunos);
		
		//RELATORIO DE LIVORS
		
		JMenuItem relLivro = new JMenuItem("Livros");
		relLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlRelatorioLivro telarelatorioA2 = new TlRelatorioLivro(livros);				
				telarelatorioA2.setVisible(true);				
				
			}
		});
		menurelatorios.add(relLivro);
		
		//RELATORIO DE LOCACOES
		
		JMenuItem btRelLocacoes = new JMenuItem("Loca\u00E7\u00F5es");
		btRelLocacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlRelatorioLocacao telarelLocacoes = new TlRelatorioLocacao(locacoes);
				telarelLocacoes.setVisible(true);
				
			}
		});
		menurelatorios.add(btRelLocacoes);
		
		//RELATORIO DEVOLUCAO
		
		JMenuItem btRelDevolucao = new JMenuItem("Devolu\u00E7\u00F5es");
		btRelDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TlRelatorioDevolucoes telarelDevolucoes = new TlRelatorioDevolucoes(devolucoes);				
				telarelDevolucoes.setVisible(true);
				
			}
		});
		menurelatorios.add(btRelDevolucao);
		
		//TELA DE ALUGAR 
		
		JMenu mnNewMenu_2 = new JMenu("Loca\u00E7\u00E3o");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem btAlugarLivro = new JMenuItem("Alugar");
		btAlugarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlAlugar telaAlugar = new TlAlugar(locacoes, alunos, livros);
				telaAlugar.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(btAlugarLivro);
		
		//TELA DE DEVOLUCAO
		
		JMenuItem btDevolucao = new JMenuItem("Devolu\u00E7\u00E3o");
		btDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlDevolucao telaDevolucao = new TlDevolucao(locacoes,livros, devolucoes);
				telaDevolucao.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(btDevolucao);
		
		//COMECA OS BOTOES DE ATALHOS
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ATALHO CADASTRO ALUNO
		
		JButton btAtalhoAlu = new JButton("");
		btAtalhoAlu.setIcon(new ImageIcon("C:\\SoftwareBiblioteca\\Imagens\\aluno.png"));
		btAtalhoAlu.setForeground(Color.BLACK);
		btAtalhoAlu.setBackground(Color.LIGHT_GRAY);
		btAtalhoAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlCadastroAlu telaaluno = new TlCadastroAlu(alunos);
				telaaluno.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Cadastro de alunos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		// ATALHO CADASTRO LIVRO
		
		JButton btAtalhoCadastroLivro = new JButton("");
		btAtalhoCadastroLivro.setBackground(Color.LIGHT_GRAY);
		btAtalhoCadastroLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlCadastroLivro telalivro = new TlCadastroLivro(livros);
				telalivro.setVisible(true);
			}
		});
		btAtalhoCadastroLivro.setIcon(new ImageIcon("C:\\SoftwareBiblioteca\\Imagens\\cadLivro.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro livro");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		// ATALHO RELATORIOS DE LIVROS
		
		
		JButton btAtalhoRelLivros = new JButton("");
		btAtalhoRelLivros.setBackground(Color.LIGHT_GRAY);
		btAtalhoRelLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlRelatorioLivro telarelatorioA2 = new TlRelatorioLivro(livros);				
				telarelatorioA2.setVisible(true);
				
			}
		});
		btAtalhoRelLivros.setIcon(new ImageIcon("C:\\SoftwareBiblioteca\\Imagens\\relLivro.png"));
		
		JLabel lblNewLabel_1_1 = new JLabel("Relat\u00F3rio de livros");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		// ATALHO RELATORIOS DE ALUNOS
		
		JButton btAtalhoRelAlunos = new JButton("");
		btAtalhoRelAlunos.setBackground(Color.LIGHT_GRAY);
		btAtalhoRelAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlRelatorioAluno telarelatorioAl = new TlRelatorioAluno(alunos);
				telarelatorioAl.setVisible(true);

			}
		});
		btAtalhoRelAlunos.setIcon(new ImageIcon("C:\\SoftwareBiblioteca\\Imagens\\relAlunos.png"));
		
		JLabel lblRelatriosDeAlunos = new JLabel("Relat\u00F3rios de alunos");
		lblRelatriosDeAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatriosDeAlunos.setBackground(Color.BLACK);
		lblRelatriosDeAlunos.setFont(new Font("Arial", Font.BOLD, 12));
		
		// ATALHO RELATORIOS DE ALUGUEIS
		
		JButton btAtalhoAlugarLivro = new JButton("");
		btAtalhoAlugarLivro.setBackground(Color.LIGHT_GRAY);
		btAtalhoAlugarLivro.setIcon(new ImageIcon("C:\\SoftwareBiblioteca\\Imagens\\Alugar1.png"));
		btAtalhoAlugarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlAlugar telaAlugar = new TlAlugar(locacoes, alunos, livros);
				telaAlugar.setVisible(true);
				
			}
		});
		
		// ATALHO RELATORIOS DE LOCACOES
		
		JButton btAtalhoRelLocacoes = new JButton("");
		btAtalhoRelLocacoes.setBackground(Color.LIGHT_GRAY);
		btAtalhoRelLocacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TlRelatorioLocacao telarelLocacoes = new TlRelatorioLocacao(locacoes);				
				telarelLocacoes.setVisible(true);
			}
		});
		btAtalhoRelLocacoes.setIcon(new ImageIcon("C:\\SoftwareBiblioteca\\Imagens\\RelLocacao.png"));
		
		JLabel lblRelatriosDeClientes_1 = new JLabel("Alugar livro");
		lblRelatriosDeClientes_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatriosDeClientes_1.setBackground(Color.BLACK);
		lblRelatriosDeClientes_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Relat\u00F3rio de loca\u00E7\u00F5es");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		// BOTAO DE ATALHO DE DEVOLUCAO
		
		JButton btAtalhoDevolLivro = new JButton("");
		btAtalhoDevolLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TlDevolucao telaDevolucao = new TlDevolucao(locacoes,livros, devolucoes);
				telaDevolucao.setVisible(true);
			}
		});
		
		btAtalhoDevolLivro.setBackground(Color.LIGHT_GRAY);
		btAtalhoDevolLivro.setIcon(new ImageIcon("C:\\SoftwareBiblioteca\\Imagens\\DevolLivro.png"));
		
		// BOTAO DE ATALHO DE RELATORIOS DE DEVOLUCOES
		
		JButton btAtalhoRelDev = new JButton("");
		btAtalhoRelDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TlRelatorioDevolucoes telarelDevolucoes = new TlRelatorioDevolucoes(devolucoes);				
				telarelDevolucoes.setVisible(true);
			}
		});
		btAtalhoRelDev.setBackground(Color.LIGHT_GRAY);
		btAtalhoRelDev.setIcon(new ImageIcon("C:\\SoftwareBiblioteca\\Imagens\\relHistorico.png"));
		
		JLabel lblRelatriosDeClientes_1_1 = new JLabel("Devolver livro");
		lblRelatriosDeClientes_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Relat\u00F3rio de devolu\u00E7\u00F5es");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Gerenciamento de Biblioteca");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btAtalhoCadastroLivro, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(10)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(6)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(17)
									.addComponent(btAtalhoAlu, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(63)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btAtalhoRelLivros, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblRelatriosDeAlunos)))
									.addGap(142))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(61)
									.addComponent(btAtalhoRelAlunos, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(31)
									.addComponent(btAtalhoRelLocacoes, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(17)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(16)
													.addComponent(btAtalhoAlugarLivro, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblRelatriosDeClientes_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(btAtalhoRelDev, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
													.addGap(36))
												.addComponent(lblRelatriosDeClientes_1_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
												.addComponent(btAtalhoDevolLivro, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))))
						.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btAtalhoAlu, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btAtalhoRelAlunos, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblRelatriosDeAlunos, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btAtalhoAlugarLivro, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(btAtalhoDevolLivro, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRelatriosDeClientes_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRelatriosDeClientes_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btAtalhoRelLocacoes, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(btAtalhoRelDev, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btAtalhoRelLivros, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btAtalhoCadastroLivro, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(86))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
