package br.com.senai.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPrincipal extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal frame = new ViewPrincipal();
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
	public ViewPrincipal() {
		setTitle("Sistema de Venda de Ornintorrincos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 23);
		contentPane.add(menuBar);
		
		JMenu menuCadastros = new JMenu("Cadastros");
		menuBar.add(menuCadastros);
		
		JMenuItem itemOrnitorrinco = new JMenuItem("Ornitorrinco");
		itemOrnitorrinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroDeOrnitorrinco cadastro = new ViewCadastroDeOrnitorrinco();
				cadastro.setVisible(true);
			}
		});
		menuCadastros.add(itemOrnitorrinco);
		
		JMenu menuConsultas = new JMenu("Consulta");
		menuBar.add(menuConsultas);
		
		JMenuItem itemConsultaOrnitorrinco = new JMenuItem("Ornitorrinco");
		itemConsultaOrnitorrinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaDeOrnitorrinco consulta = new ViewConsultaDeOrnitorrinco();
				consulta.setVisible(true);
			}
		});
		menuConsultas.add(itemConsultaOrnitorrinco);
	}
}
