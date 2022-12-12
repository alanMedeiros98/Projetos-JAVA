package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.senai.entity.Animal;
import br.com.senai.entity.Aposta;
import br.com.senai.entity.Cidade;
import br.com.senai.entity.Corrida;
import br.com.senai.service.CorridaService;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ViewCorrida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Random random = new Random();
	private JLabel lblNewLabel;

	public ViewCorrida() {

		setTitle("Corrida");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Corrida dos bixos malukos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(461, 33, 441, 41);
		contentPane.add(lblNewLabel);

		JLabel Cavalo1 = new JLabel("");
		Cavalo1.setIcon(new ImageIcon(ViewCorrida.class.getResource("/br/com/senai/imagens/Cavalo1.png")));
		Cavalo1.setBounds(50, 202, 158, 108);
		contentPane.add(Cavalo1);

		JLabel Cavalo2 = new JLabel("");
		Cavalo2.setIcon(new ImageIcon(ViewCorrida.class.getResource("/br/com/senai/imagens/Cavalo2.png")));
		Cavalo2.setBounds(50, 350, 158, 108);
		contentPane.add(Cavalo2);

		JLabel Cavalo3 = new JLabel("");
		Cavalo3.setIcon(new ImageIcon(ViewCorrida.class.getResource("/br/com/senai/imagens/Cavalo3.png")));
		Cavalo3.setBounds(50, 496, 158, 108);
		contentPane.add(Cavalo3);
		
		CorridaService serviceCorrida = new CorridaService();
		JComboBox<Corrida> cbNrCorrida = new JComboBox(serviceCorrida.listarCorrida().toArray());
		cbNrCorrida.setFont(new Font("Arial", Font.PLAIN, 18));
		cbNrCorrida.setEnabled(false);
		cbNrCorrida.setBounds(10, 11, 172, 28);
		contentPane.add(cbNrCorrida);


		JButton btnIniciarCorrida = new JButton("Iniciar Corrida");
		btnIniciarCorrida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Thread(new Runnable() {

					@Override
					public void run() {
						Corrida correr = new Corrida();
						Animal animal = new Animal();
						int posicaoCavalo0 = 0;
						int posicaoCavalo1 = 0;
						int posicaoCavalo2 = 0;

						JOptionPane.showMessageDialog(contentPane, "Aguarder os cavalos estao correndo...");
						do {

							posicaoCavalo0 += correr.sorteio1();
							Cavalo1.setBounds(posicaoCavalo0, 202, 414, 239);
							posicaoCavalo1 += correr.sorteio2();
							Cavalo2.setBounds(posicaoCavalo1, 350, 414, 239);
							posicaoCavalo2 += correr.sorteio3();
							Cavalo3.setBounds(posicaoCavalo2, 496, 414, 239);
							try {
								Thread.sleep(500);
							} catch (Exception e2) {
								e2.printStackTrace();
							}

						} while (correr.total[0] <= 950 || correr.total[1] <= 950 || correr.total[2] <= 950);

						if (correr.total[0] >= 950 && correr.total[0] > correr.total[1]
								&& correr.total[0] > correr.total[2]) {
							animal.setNome("Valquiria");
							JOptionPane.showMessageDialog(contentPane, "Parabéns a " + animal.getNome() + " foi a vencedora");
							int vencedor = 1;
							Corrida corrida =(Corrida)cbNrCorrida.getModel().getSelectedItem();
							
							
							
						}
						if (correr.total[1] >= 950 && correr.total[1] > correr.total[0]
								&& correr.total[1] > correr.total[2]) {
							animal.setNome("Pé de pano");
							JOptionPane.showMessageDialog(contentPane, "Parabéns o " + animal.getNome() + " foi o vencedor");
							int vencedor = 2;
							
						}
						if (correr.total[2] >= 950 && correr.total[2] > correr.total[1]
								&& correr.total[2] > correr.total[0]) {
							animal.setNome("Carpeado");
							JOptionPane.showMessageDialog(contentPane, "Parabéns o " + animal.getNome() + " foi o vencedor");
							int vencedor = 3;
							
						}

							JOptionPane.showMessageDialog(contentPane, "Saia e volte da tela para iniciar uma nova corrida!");

					}
				}).start();
				;

			}
		});
		btnIniciarCorrida.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnIniciarCorrida.setBounds(597, 698, 149, 27);
		contentPane.add(btnIniciarCorrida);

		JButton btnApostar = new JButton("Apostar");
		btnApostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewApostar apostar = new ViewApostar();
				apostar.setVisible(true);
			}
		});
		btnApostar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnApostar.setBounds(65, 701, 117, 23);
		contentPane.add(btnApostar);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewCorrida.class.getResource("/br/com/senai/imagens/Linha2.png")));
		lblNewLabel_1.setBounds(1216, 201, 28, 478);
		contentPane.add(lblNewLabel_1);

		
		JLabel lblNewLabel_2 = new JLabel("Chegada");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(ViewCorrida.class.getResource("/br/com/senai/imagens/bandeira.png")));
		lblNewLabel_2.setBounds(1206, 34, 172, 213);
		contentPane.add(lblNewLabel_2);

	}
}
