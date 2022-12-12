package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Incidente;
import br.com.senai.core.service.IncidenteService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroIncidente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtDescricaoCurta;
	private JTextField edtGravidade;
	
	private IncidenteService service;
	private Incidente incidente;

	public ViewCadastroIncidente() {
		this.service = new IncidenteService();
		setResizable(false);
		setTitle("Gerenciar Incidente - Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescricaoCurta = new JLabel("Descri\u00E7\u00E3o Curta*");
		lblDescricaoCurta.setBounds(12, 60, 112, 16);
		contentPane.add(lblDescricaoCurta);
		
		edtDescricaoCurta = new JTextField();
		edtDescricaoCurta.setBounds(12, 78, 294, 20);
		contentPane.add(edtDescricaoCurta);
		edtDescricaoCurta.setColumns(10);
		
		JLabel lblGravidade = new JLabel("Gravidade*");
		lblGravidade.setBounds(318, 60, 72, 16);
		contentPane.add(lblGravidade);
		
		edtGravidade = new JTextField();
		edtGravidade.setBounds(318, 78, 91, 20);
		contentPane.add(edtGravidade);
		edtGravidade.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaIncidente view = new ViewConsultaIncidente();
				view.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(311, 21, 98, 26);
		contentPane.add(btnConsultar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String  descricaoCurta = edtDescricaoCurta.getText();
					String  gravidadeString = edtGravidade.getText();
					
					if (descricaoCurta.isEmpty() || gravidadeString.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Todos os campos"
								+ " devem ser obrigatórios!");										
					} else {	
					if (incidente == null) {
						int gravidade = Integer.parseInt(gravidadeString);
						incidente = new Incidente(descricaoCurta, gravidade);
						service.salvar(incidente);
						JOptionPane.showMessageDialog(contentPane, "Incidente salvo com sucesso!");
						incidente = null;
					} else {
						int gravidade = Integer.parseInt(gravidadeString);
						incidente.setDescricaoCurta(descricaoCurta);
						incidente.setGravidade(gravidade);
						service.salvar(incidente);
						JOptionPane.showMessageDialog(contentPane, "Incidente alterado com sucesso!");
					}
				}  } catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "O campo da gravidade aceita apenas números inteiros positivos.");
				}
				 catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
	
			}
		});
		btnSalvar.setBounds(311, 111, 98, 26);
		contentPane.add(btnSalvar);
		setLocationRelativeTo(null);
	}
	
	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
		this.edtDescricaoCurta.setText(incidente.getDescricaoCurta());
		this.edtGravidade.setText(String.valueOf( incidente.getGravidade()));
		
	}

}
