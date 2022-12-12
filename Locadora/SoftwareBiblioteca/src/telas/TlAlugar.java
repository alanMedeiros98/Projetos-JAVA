package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Aluno;
import classes.Livro;
import classes.AlugarLivro;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class TlAlugar extends JFrame {

	private JPanel contentPane;
	private JTextField cpIdLivro;
	private JTextField cpData;
	private JTextField cpIdaluno;

	public TlAlugar(ArrayList<AlugarLivro> locacoes, ArrayList<Aluno> alunos, ArrayList<Livro> livros) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Loca\u00E7\u00E3o de livros");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel lblNewLabel_1_1 = new JLabel("ID livro:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpIdLivro = new JTextField();
		cpIdLivro.setColumns(10);
		
		JButton btLocar = new JButton("Locar");
		btLocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					AlugarLivro alugarLivro = new AlugarLivro();
					Aluno aluno = new Aluno();
					Livro livro = new Livro();
					
					Integer idAluno = Integer.parseInt(cpIdaluno.getText());
					Integer idLivro = Integer.parseInt(cpIdLivro.getText());
					String dataEntrega = cpData.getText();
					
					aluno = aluno.consultarPorId(alunos, idAluno);
					livro = livro.consultarPorId(livros, idLivro);
					
					if (livro.getAlugado().equals(false)) {
						
						locacoes.add(alugarLivro.alugar(aluno, livro, dataEntrega));
						JOptionPane.showMessageDialog(null, "Livro alugado com sucesso!!");
					} else {
						JOptionPane.showMessageDialog(null, "Esse livro ja esta alugado");
						cpIdLivro.setText("");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Preencha os dados corretamente!!");
					cpIdaluno.setText("");
					cpIdLivro.setText("");
					cpData.setText("");
				}
				
				
				
			}
		});
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID aluno:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpData = new JTextField();
		cpData.setColumns(10);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Data entrega:");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpIdaluno = new JTextField();
		cpIdaluno.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(276, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(266))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpIdaluno, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpIdLivro, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btLocar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpData, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane_1)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(94)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpIdaluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1)
								.addComponent(cpIdLivro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addComponent(btLocar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		JList listLivros = new JList(livros.toArray());
		scrollPane_1.setViewportView(listLivros);
		
		JLabel lblNewLabel_2 = new JLabel("Livros");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		scrollPane_1.setColumnHeaderView(lblNewLabel_2);
		
		JList listAlunos = new JList(alunos.toArray());
		scrollPane.setViewportView(listAlunos);
		
		JLabel lblNewLabel_1 = new JLabel("Alunos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
