package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.senai.core.domain.Confirmacao;
import br.com.senai.core.domain.Projeto;
import br.com.senai.core.domain.Status;
import br.com.senai.core.service.ProjetoService;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewCadastroProjeto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField edtDescricaoCurta;
	private JTextField edtValor;
	private JTextField edtPrazo;
	private JTextField edtDataDeFim;
	private JCheckBox chkAtivo;
	private JTextArea taDetalhamento;
	private JFormattedTextField ftfDataDeInicio;
	private JComboBox<Status> cbStatus;
	
	private ProjetoService service;
	private Projeto projeto;

	/**
	 * Create the frame.
	 */
	public ViewCadastroProjeto() {
		this.service = new ProjetoService();		
		setResizable(false);
		setTitle("Gerenciar Projetos - Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaProjeto view = new ViewConsultaProjeto();
				view.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(317, 11, 107, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o Curta*");
		lblNewLabel.setBounds(10, 32, 107, 16);
		contentPane.add(lblNewLabel);
		
		edtDescricaoCurta = new JTextField();
		edtDescricaoCurta.setBounds(10, 59, 230, 20);
		contentPane.add(edtDescricaoCurta);
		edtDescricaoCurta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Status*");
		lblNewLabel_1.setBounds(252, 32, 55, 16);
		contentPane.add(lblNewLabel_1);
		
		cbStatus = new JComboBox<Status>();		
		cbStatus.setBounds(250, 59, 174, 20);
		cbStatus.setEnabled(false);
		this.carregarCombo();
		contentPane.add(cbStatus);
		
		JLabel lblNewLabel_2 = new JLabel("Valor (R$)*");
		lblNewLabel_2.setBounds(10, 90, 71, 16);
		contentPane.add(lblNewLabel_2);
		
		edtValor = new JTextField();
		edtValor.setBounds(10, 117, 71, 20);
		contentPane.add(edtValor);
		edtValor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data In\u00EDcio*");
		lblNewLabel_3.setBounds(91, 90, 71, 16);
		contentPane.add(lblNewLabel_3);
		
		ftfDataDeInicio = new JFormattedTextField();
		ftfDataDeInicio.setBounds(91, 117, 85, 20);
		contentPane.add(ftfDataDeInicio);
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			mascara.install(ftfDataDeInicio);					
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		JLabel lblNewLabel_4 = new JLabel("Prazo*");
		lblNewLabel_4.setBounds(185, 90, 55, 16);
		contentPane.add(lblNewLabel_4);
		
		edtPrazo = new JTextField();
		edtPrazo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					if (!ftfDataDeInicio.getText().equals("  /  /    ")
							&& !edtPrazo.getText().isBlank()) {
						
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate dataDeInicio = LocalDate.from(dtf.parse(ftfDataDeInicio.getText())); 
						int prazo = Integer.parseInt(edtPrazo.getText());
						LocalDate dataDeFim = service.gerarDataFinalPor(dataDeInicio, prazo);
						edtDataDeFim.setText(dtf.format(dataDeFim));
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		edtPrazo.setBounds(186, 117, 63, 20);
		contentPane.add(edtPrazo);
		edtPrazo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Data Fim*");
		lblNewLabel_5.setBounds(260, 90, 55, 16);
		contentPane.add(lblNewLabel_5);
		
		edtDataDeFim = new JTextField();
		edtDataDeFim.setEnabled(false);
		edtDataDeFim.setBounds(260, 117, 96, 20);
		contentPane.add(edtDataDeFim);
		edtDataDeFim.setColumns(10);
		
		chkAtivo = new JCheckBox("Ativo");
		chkAtivo.setBounds(369, 117, 55, 20);
		contentPane.add(chkAtivo);
		
		JLabel lblNewLabel_6 = new JLabel("Especifica\u00E7\u00F5es");
		lblNewLabel_6.setBounds(10, 148, 107, 16);
		contentPane.add(lblNewLabel_6);
		
		taDetalhamento = new JTextArea();
		taDetalhamento.setBounds(10, 175, 414, 163);
		contentPane.add(taDetalhamento);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String descricaoCurta = edtDescricaoCurta.getText();
					String detalhamento = taDetalhamento.getText();
					Status status = (Status)cbStatus.getSelectedItem();
					int prazo = Integer.parseInt(edtPrazo.getText());
					double valor = Double.parseDouble(edtValor.getText());
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataDeInicio = LocalDate.from(dtf.parse(ftfDataDeInicio.getText()));
					Confirmacao ativo = chkAtivo.isSelected() ? Confirmacao.S : Confirmacao.N;
					
					if (projeto == null) {
						projeto = new Projeto(descricaoCurta, detalhamento, prazo, 
								valor, status, ativo, dataDeInicio);
					}else {					
						projeto.setDescricaoCurta(descricaoCurta);
						projeto.setDetalhamento(detalhamento);
						projeto.setStatus(status);
						projeto.setPrazo(prazo);
						projeto.setValor(valor);
						projeto.setDataDeInicio(dataDeInicio);
						projeto.setAtivo(ativo);
					}
					service.salvar(projeto);
					JOptionPane.showMessageDialog(contentPane, "Projeto salvo com sucesso");					
				}catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "Os campos de prazo e valor só aceitam números");
				}catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnSalvar.setBounds(326, 349, 98, 26);
		contentPane.add(btnSalvar);
		setLocationRelativeTo(null);
	}
	
	private void carregarCombo() {
		for (Status s : Status.values()) {
			this.cbStatus.addItem(s);
		}
	}
	
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
		this.edtDescricaoCurta.setText(projeto.getDescricaoCurta());
		this.taDetalhamento.setText(projeto.getDetalhamento());
		this.edtPrazo.setText(String.valueOf(projeto.getPrazo()));
		this.edtValor.setText(String.valueOf(projeto.getValor()));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String dataInicialFormatada = projeto.getDataDeInicio().format(dtf);
		this.ftfDataDeInicio.setText(dataInicialFormatada);
		
		String dataDeFimFormatada = projeto.getDataDeFim().format(dtf);
		this.edtDataDeFim.setText(dataDeFimFormatada);
		
		this.cbStatus.setSelectedItem(projeto.getStatus());
		if (projeto.getId() > 0 && projeto.getStatus() == Status.N || projeto.getStatus() == Status.I) {
			this.cbStatus.setEnabled(true);
		}		

		this.chkAtivo.setSelected(projeto.getAtivo() == Confirmacao.S);
		
	}
}
