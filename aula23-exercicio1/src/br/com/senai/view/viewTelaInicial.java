package br.com.senai.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class viewTelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewTelaInicial frame = new viewTelaInicial();
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
	public viewTelaInicial() {
		setResizable(false);
		setTitle("CLINICA SESI - M\u00F3dulo de Gest\u00E3o de Pacientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar mbItens = new JMenuBar();
		mbItens.setBounds(0, 0, 434, 22);
		contentPane.add(mbItens);
		
		JMenu mnCadastro = new JMenu("Cadastros");
		mbItens.add(mnCadastro);
		
		JMenuItem mniPacientes = new JMenuItem("Pacientes");
		mniPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewCadastroPacientes paciente = new viewCadastroPacientes();
				paciente.setVisible(true);
			}
		});
		mnCadastro.add(mniPacientes);
		
		JMenu mnSair = new JMenu("Sair");
		mbItens.add(mnSair);
	}
}
