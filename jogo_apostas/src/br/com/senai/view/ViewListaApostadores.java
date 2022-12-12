package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.entity.Aposta;
import br.com.senai.service.ApostarService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ViewListaApostadores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewListaApostadores() {
		setTitle("Lista de apostadores");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista dos apostadores");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(120, 11, 144, 17);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 364, 419);
		contentPane.add(scrollPane);
		
		ApostarService serviceAposta = new ApostarService();
		JList<Aposta> list = new JList(serviceAposta.ListarApostas().toArray());
		scrollPane.setViewportView(list);
	}
}
