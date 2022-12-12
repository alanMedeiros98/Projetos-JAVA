package br.com.senai.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.RuntimeErrorException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.dao.DaoPaciente;
import br.com.senai.dao.FactoryDao;
import br.com.senai.domain.Paciente;
import br.com.senai.domain.Tipo;

public class viewCadastroPacientes extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;

	public viewCadastroPacientes() {
		setTitle("Gerenciar Pacientes - Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome completo*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 65, 141, 22);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(10, 89, 238, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade*");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdade.setBounds(255, 69, 67, 14);
		contentPane.add(lblIdade);
		
		textIdade = new JTextField();
		textIdade.setBounds(255, 89, 86, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo*");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(348, 69, 67, 14);
		contentPane.add(lblTipo);
		
		JComboBox<Tipo> cbItens = new JComboBox<Tipo>(Tipo.values());
		cbItens.setSelectedIndex(-1);
		cbItens.setBounds(348, 88, 86, 22);
		contentPane.add(cbItens);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(348, 30, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					FactoryDao fabrica = new FactoryDao();
					DaoPaciente dao = fabrica.getDaoPaciente();
					Paciente paciente = null;
					
					String nome = textNome.getText();
					int idade = Integer.parseInt(textIdade.getText());
					Tipo tipo = null;
					int opcaoSelecionada = cbItens.getSelectedIndex();
					if (opcaoSelecionada == 1) {
						tipo = Tipo.R;
					}else {
						tipo = Tipo.D;
					}
					
					paciente = new Paciente(nome, idade, tipo);
					dao.inserir(paciente);
					JOptionPane.showMessageDialog(contentPane, "Paciente cadastrado com sucesso.");
										
				} catch (Exception e) {
					throw new RuntimeErrorException(null, "Ocorreu um erro ao cadastrar. Motivo: " + e.getMessage());
				}
				
			}
		});
		btnSalvar.setBounds(348, 128, 89, 23);
		contentPane.add(btnSalvar);
	}
}
