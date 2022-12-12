package br.com.senai.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.entity.Cidade;
import br.com.senai.execessoes.NomeObrigatorio;
import br.com.senai.service.CidadeService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewCidade extends JFrame {

	private JPanel contentPane;
	private JTextField edtNome;
	private JTextField edtUF;
	
	private ArrayList<Cidade> cidades = new ArrayList<Cidade>();

	public ViewCidade() {

		setResizable(false);
		setTitle("Cadastro de Cidade");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 491, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(10, 27, 46, 14);
		contentPane.add(lblNewLabel);

		edtNome = new JTextField();
		edtNome.setBounds(10, 44, 260, 20);
		contentPane.add(edtNome);
		edtNome.setColumns(10);

		JLabel lblUF = new JLabel("UF:");
		lblUF.setBounds(318, 27, 46, 14);
		contentPane.add(lblUF);

		edtUF = new JTextField();
		edtUF.setBounds(318, 44, 86, 20);
		contentPane.add(edtUF);
		edtUF.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String nome = edtNome.getText();
					String uf = edtUF.getText();
					Cidade cidade = new Cidade();
					cidade.setNome(nome);
					cidade.setUf(uf);
					CidadeService service = new CidadeService();
					service.inserir(cidade);
					edtNome.setText("");
					edtUF.setText("");
				} catch (NomeObrigatorio no) {
					JOptionPane.showMessageDialog(contentPane, no.getMessage());
					edtNome.setText("");
					edtUF.setText("");
				}

			}
		});
		btnSalvar.setBounds(10, 75, 89, 23);
		contentPane.add(btnSalvar);
	}
}
