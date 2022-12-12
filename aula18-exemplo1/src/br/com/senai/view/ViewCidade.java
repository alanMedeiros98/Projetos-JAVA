package br.com.senai.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.domain.Cidade;
import br.com.senai.persistencia.MantenedorDeCidades;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCidade extends JFrame {

	private JPanel contentPane;
	private JTextField edtNome;
	private JTextField edtUF;
	private MantenedorDeCidades mantenedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCidade frame = new ViewCidade();
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
	public ViewCidade() {
		this.mantenedor = new MantenedorDeCidades();
		setResizable(false);
		setTitle("Cadastro de Cidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		edtNome = new JTextField();
		edtNome.setBounds(10, 36, 309, 20);
		contentPane.add(edtNome);
		edtNome.setColumns(10);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setBounds(332, 11, 46, 14);
		contentPane.add(lblUF);
		
		edtUF = new JTextField();
		edtUF.setBounds(329, 36, 86, 20);
		contentPane.add(edtUF);
		edtUF.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = edtNome.getText();
					String uf = edtUF.getText();
					Cidade cidade = new Cidade(nome, uf);
					mantenedor.inserir(cidade);
					JOptionPane.showMessageDialog(contentPane, "Cidade salva com sucesso");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
				
			}
		});
		btnSalvar.setBounds(326, 67, 89, 23);
		contentPane.add(btnSalvar);
	}
}
