package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Aluno;
import classes.MetodoTextos;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTextArea;

public class TlAlteracaoAlu extends JFrame {

	private JPanel contentPane;
	private JTextField cpNome;
	private JTextField cpCpf;
	private JTextField cpIdade;
	private JTextField cpId;


	public TlAlteracaoAlu(ArrayList<Aluno> alunos) {
		
		
		
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpNome = new JTextField();
		cpNome.setColumns(10);
		cpNome.setDocument(new MetodoTextos(20, MetodoTextos.TipoEntrada.nome));
		
		JLabel lblNewLabel_1 = new JLabel("Altera\u00E7\u00E3o de aluno");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 25));
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpCpf = new JTextField();
		cpCpf.setColumns(10);
		cpCpf.setDocument(new MetodoTextos(11, MetodoTextos.TipoEntrada.numerodecimal));
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpIdade = new JTextField();
		cpIdade.setColumns(10);
		cpIdade.setDocument(new MetodoTextos(3, MetodoTextos.TipoEntrada.numerodecimal));
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				
				Integer id = Integer.parseInt(cpId.getText());					
				
				String nome = cpNome.getText();				
				String cpf = cpCpf.getText();
				Integer idade = Integer.parseInt(cpIdade.getText());
				
				
				for (int i = 0; i < alunos.size(); i++) {
					if (id == alunos.get(i).getId()) {
						alunos.set(i, aluno.alterar(id, nome, cpf, idade));
						
					}
				}
				
				JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!!");
				
				cpNome.setText("");
				cpCpf.setText("");
				cpIdade.setText("");
								
			}
		});
		
		JButton btConsultar = new JButton("Consultar");
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();	
				aluno = aluno.consultarPorId(alunos, Integer.parseInt(cpId.getText()));
				
				if(aluno != null) {
					cpNome.setText(aluno.getNome());
					cpCpf.setText(aluno.getCpf());
					cpIdade.setText(aluno.getIdade().toString());					
				}		
			}
		});
		
		JButton btRemover = new JButton("Remover");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				
				Integer id = Integer.parseInt(cpId.getText());	
				
				id = Integer.parseInt(cpId.getText());
				
				for (int i = 0; i < alunos.size(); i++) {
					if (id.equals(alunos.get(i).getId())) {
						alunos.remove(alunos.get(i));
						
					}
				}
				
				JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
			}
		});
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpId = new JTextField();
		cpId.setColumns(10);
		cpId.setDocument(new MetodoTextos(10, MetodoTextos.TipoEntrada.numerodecimal));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(235)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btConsultar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btSalvar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btRemover, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpIdade, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cpCpf, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cpId, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addComponent(cpNome, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cpNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btConsultar)
						.addComponent(btSalvar)
						.addComponent(btRemover))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
