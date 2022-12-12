package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Aluno;
import classes.Livro;
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
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class TlAlteracaoLivro extends JFrame {

	private JPanel contentPane;
	private JTextField cpTitulo;
	private JTextField cpAutor;
	private JTextField cpGenero;
	private JTextField cpAno;
	private JTextField cpId;


	public TlAlteracaoLivro(ArrayList<Livro> livros) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpTitulo = new JTextField();
		cpTitulo.setColumns(10);
		cpTitulo.setDocument(new MetodoTextos(15, MetodoTextos.TipoEntrada.titulo));
		
		JLabel lblNewLabel_1 = new JLabel("Altera\u00E7\u00E3o de Livro");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 25));
		
		JLabel lblCpf = new JLabel("Autor:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpAutor = new JTextField();
		cpAutor.setColumns(10);
		cpAutor.setDocument(new MetodoTextos(15, MetodoTextos.TipoEntrada.nome));
		
		JLabel lblIdade = new JLabel("Genero:");
		lblIdade.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpGenero = new JTextField();
		cpGenero.setColumns(10);
		cpGenero.setDocument(new MetodoTextos(15, MetodoTextos.TipoEntrada.nome));
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro livro = new Livro();
				
				Integer id = Integer.parseInt(cpId.getText());	
				String titulo = cpTitulo.getText();				
				String autor = cpAutor.getText();
				String genero = cpGenero.getText();
				Integer ano = Integer.parseInt(cpAno.getText());
				
				
				for (int i = 0; i < livros.size(); i++) {
					if (id == livros.get(i).getId()) {
						livros.set(i, livro.alterar(id, titulo, autor, genero, ano));
						
					}
				}
				
				JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!!");
				
				cpTitulo.setText("");
				cpAutor.setText("");
				cpGenero.setText("");
				cpAno.setText("");
				
				
			}
		});
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpAno = new JTextField();
		cpAno.setColumns(10);
		cpAno.setDocument(new MetodoTextos(4, MetodoTextos.TipoEntrada.numerodecimal));
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Arial", Font.BOLD, 15));
		
		cpId = new JTextField();
		cpId.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro livro = new Livro();	
				livro = livro.consultarPorId(livros, Integer.parseInt(cpId.getText()));
				
				if(livro != null) {
					cpTitulo.setText(livro.getTitulo());
					cpAutor.setText(livro.getAutor());
					cpGenero.setText(livro.getGenero());					
					cpAno.setText(livro.getAno().toString());					
				}

				
			}
		});
		
		JButton btRemover = new JButton("Remover");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Livro livro = new Livro();
				
				Integer id = Integer.parseInt(cpId.getText());	
				
				
				for (int i = 0; i < livros.size(); i++) {
					if (id.equals(livros.get(i).getId())) {
						livros.remove(livros.get(i));
						
					}
				}
				
				JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cpTitulo, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cpGenero, 336, 336, 336))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cpAutor, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)))
							.addContainerGap(334, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpAno, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btSalvar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btRemover, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cpId, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(639, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(267))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(cpTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConsultar)
						.addComponent(btRemover)
						.addComponent(btSalvar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
