package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.entity.Cidade;
import br.com.senai.entity.Pessoa;
import br.com.senai.execessoes.CidadeInvalida;
import br.com.senai.execessoes.IdadeInvalida;
import br.com.senai.execessoes.NomeObrigatorio;
import br.com.senai.service.CidadeService;
import br.com.senai.service.PessoaService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class viewCadastroPessoa extends JFrame {

	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtNome;
	private JTextField edtIdade;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;

	public viewCadastroPessoa() {
		setTitle("Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 60, 54, 14);
		contentPane.add(lblNewLabel);
		
		edtNome = new JTextField();
		edtNome.setBounds(67, 60, 328, 20);
		contentPane.add(edtNome);
		edtNome.setColumns(10);
		
		
		edtIdade = new JTextField();
		edtIdade.setBounds(67, 100, 46, 20);
		contentPane.add(edtIdade);
		edtIdade.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Idade:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(11, 100, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cidade:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 140, 54, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Cadastro de pessoa");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(205, 11, 173, 14);
		contentPane.add(lblNewLabel_3);
		
		CidadeService serviceCidade = new CidadeService();
		JComboBox<Cidade> comboBox = new JComboBox(serviceCidade.listarCidade().toArray());
		
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setBounds(67, 137, 159, 22);
		contentPane.add(comboBox);
		
		btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nome = edtNome.getText();
					Integer idade = Integer.parseInt(edtIdade.getText());
					
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(nome);
					pessoa.setIdade(idade);
					
					
					edtNome.setText("");
					edtIdade.setText("");
					
					Cidade cidade =(Cidade)comboBox.getModel().getSelectedItem();
					pessoa.setCidade(cidade);
					PessoaService service = new PessoaService();
					service.inserir(pessoa);
					
				} catch (NomeObrigatorio no) {
					JOptionPane.showMessageDialog(contentPane, no.getMessage());
					edtNome.setText("");
				} catch (IdadeInvalida id){
					JOptionPane.showMessageDialog(contentPane, id.getMessage());
					edtIdade.setText("");
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane,"Nao pode ser nulo");
					edtIdade.setText("");
				} catch (CidadeInvalida ci) {
					JOptionPane.showMessageDialog(contentPane, ci.getMessage());
				}
			}
		});
		btnNewButton.setBounds(24, 207, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("* Primeiro cadastre uma cidade");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_4.setBounds(424, 228, 155, 13);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
