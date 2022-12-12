package br.com.senai.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.entity.Cidade;
import br.com.senai.service.CidadeService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

public class viewListaCidade extends JFrame {

	private JPanel contentPane;


	public viewListaCidade() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de cidade");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(126, 11, 122, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 67, 354, 443);
		contentPane.add(scrollPane);
		
		CidadeService serviceCidade = new CidadeService();
		JList<Cidade> list = new JList(serviceCidade.listarCidade().toArray());
		scrollPane.setViewportView(list);
	}
}
