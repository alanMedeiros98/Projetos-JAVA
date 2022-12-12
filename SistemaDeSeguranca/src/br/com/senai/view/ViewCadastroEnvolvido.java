package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Envolvido;
import br.com.senai.core.service.EnvolvidoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroEnvolvido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtNomeCompleto;
	private JTextField edtDocumento;

	private EnvolvidoService service;
	private Envolvido envolvido;

	public ViewCadastroEnvolvido() {
		this.service = new EnvolvidoService();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gerenciar Envolvido - Cadastro");
		setBounds(100, 100, 450, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeCompleto = new JLabel("Nome Completo*");
		lblNomeCompleto.setBounds(12, 56, 107, 16);
		contentPane.add(lblNomeCompleto);

		edtNomeCompleto = new JTextField();
		edtNomeCompleto.setBounds(12, 74, 410, 20);
		contentPane.add(edtNomeCompleto);
		edtNomeCompleto.setColumns(10);

		JLabel lblDocumento = new JLabel("Documento*");
		lblDocumento.setBounds(12, 107, 78, 16);
		contentPane.add(lblDocumento);

		edtDocumento = new JTextField();
		edtDocumento.setBounds(12, 124, 168, 20);
		contentPane.add(edtDocumento);
		edtDocumento.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String nomeCompleto = edtNomeCompleto.getText();
					String documento = edtDocumento.getText();

					if (nomeCompleto.isEmpty() || documento.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios");
					} else {

						if (envolvido == null) {
							envolvido = new Envolvido(nomeCompleto, documento);
							service.salvar(envolvido);
							JOptionPane.showMessageDialog(contentPane, "Envolvido inserido com sucesso!");
							envolvido = null;
						} else {
							envolvido.setNomeCompleto(nomeCompleto);
							envolvido.setDocumento(documento);
							service.salvar(envolvido);
							JOptionPane.showMessageDialog(contentPane, "Envolvido alterado com sucesso!");

						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
					envolvido = null;
				}

			}
		});
		btnSalvar.setBounds(324, 147, 98, 26);
		contentPane.add(btnSalvar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaEnvolvido view = new ViewConsultaEnvolvido();
				view.setVisible(true);
				dispose();
			}
		});

		btnConsultar.setBounds(324, 23, 98, 26);
		contentPane.add(btnConsultar);
		setLocationRelativeTo(null);

	}

	public void setEnvolvido(Envolvido envolvido) {
		this.envolvido = envolvido;
		this.edtNomeCompleto.setText(envolvido.getNomeCompleto());
		this.edtDocumento.setText(envolvido.getDocumento());
	}
}
