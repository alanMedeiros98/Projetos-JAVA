package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.entity.Pessoa;
import br.com.senai.service.PessoaService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

public class viewListaPessoa extends JFrame {

	private JPanel contentPane;

	public viewListaPessoa() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de pessoas");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(119, 11, 135, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 67, 354, 443);
		contentPane.add(scrollPane);
		
		PessoaService servicePessoa =  new PessoaService();
		JList<Pessoa> list = new JList(servicePessoa.listarPessoa().toArray());
		scrollPane.setViewportView(list);
	}
}
