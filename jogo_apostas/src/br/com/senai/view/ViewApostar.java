package br.com.senai.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.entity.Animal;
import br.com.senai.entity.Aposta;
import br.com.senai.entity.Cidade;
import br.com.senai.entity.Corrida;
import br.com.senai.entity.Pessoa;
import br.com.senai.service.AnimalService;
import br.com.senai.service.ApostarService;
import br.com.senai.service.CorridaService;
import br.com.senai.service.PessoaService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewApostar extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	Aposta apostar = new Aposta();
	
	public ViewApostar() {
		setTitle("Apostar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblApostador = new JLabel("Apostador");
		lblApostador.setHorizontalAlignment(SwingConstants.CENTER);
		lblApostador.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblApostador.setBounds(226, 11, 83, 17);
		contentPane.add(lblApostador);
		
		JLabel lblNewLabel = new JLabel("Quem ira apostar?");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 82, 103, 14);
		contentPane.add(lblNewLabel);
		
		PessoaService pessoaService = new PessoaService();
		JComboBox<Pessoa> cbPessoas = new JComboBox(pessoaService.listarPessoa().toArray());
		cbPessoas.setBounds(123, 78, 345, 20);
		contentPane.add(cbPessoas);
		
		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAnimal.setBounds(10, 129, 57, 14);
		contentPane.add(lblAnimal);
		
		AnimalService animalService = new AnimalService();
		JComboBox<Animal> cbAnimal = new JComboBox(animalService.listarAnimal().toArray());
		cbAnimal.setBounds(97, 125, 173, 22);
		contentPane.add(cbAnimal);
		
		CorridaService serviceCorrida = new CorridaService();
		JComboBox<Corrida> cbNrCorrida = new JComboBox(serviceCorrida.listarCorrida().toArray());
		cbNrCorrida.setEnabled(false);
		cbNrCorrida.setBounds(10, 184, 131, 22);
		contentPane.add(cbNrCorrida);
		
		JButton btnSalvar = new JButton("Salvar jogador");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApostarService service = new ApostarService();				
				try {
					
					Pessoa pessoa = (Pessoa)cbPessoas.getModel().getSelectedItem();
					apostar.setPessoa(pessoa);
					Animal Animal = (Animal)cbAnimal.getModel().getSelectedItem();
					apostar.setAnimal(Animal);
					CorridaService corrida = new CorridaService();
					Corrida corridaCb = (Corrida)cbNrCorrida.getModel().getSelectedItem();
					apostar.setCorrida(corridaCb);
					
					service.inserir(apostar);
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnSalvar.setBounds(297, 125, 131, 23);
		contentPane.add(btnSalvar);
	}
}
