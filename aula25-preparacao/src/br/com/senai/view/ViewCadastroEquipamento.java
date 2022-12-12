package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Equipamento;
import br.com.senai.core.domain.Status;
import br.com.senai.core.service.EquipamentoService;

public class ViewCadastroEquipamento extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField edtDescricaoCurta;
	private JTextArea jtaEspecificacoes;
	private JComboBox<String> cbStatus;
	private JTextField edtGarantia;
	
	private EquipamentoService service;	
	private Equipamento equipamento;	
	
	/**
	 * Create the frame.
	 */
	public ViewCadastroEquipamento() {
		setResizable(false);
		setTitle("Gerenciar Equipamentos - Cadastro");
		setName("frmCadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 367);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.service = new EquipamentoService();
		
		JButton btnConsultar = new JButton("Consultar");		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaEquipamento view = new ViewConsultaEquipamento();
				view.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(531, 11, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					String descricaoCurta = edtDescricaoCurta.getText();
					String especificacoes = jtaEspecificacoes.getText();
					int garantia = Integer.parseInt(edtGarantia.getText());									
					
					if (equipamento == null) {
						equipamento = new Equipamento(descricaoCurta, especificacoes, garantia);
					}else {
						
						Status status = null;
						int opcaoSelecionada = cbStatus.getSelectedIndex();
						if (opcaoSelecionada == 1) {
							status = Status.R;
						}else if(opcaoSelecionada == 2){
							status = Status.E;
						}
						
						equipamento.setDescricaoCurta(descricaoCurta);
						equipamento.setEspecificacoes(especificacoes);
						equipamento.setGarantia(garantia);
						equipamento.setStatus(status);
						
					}					
					service.salvar(equipamento);
					cbStatus.setEnabled(false);
					JOptionPane.showMessageDialog(contentPane, "Equipamento salvo com sucesso");
				}catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "O campo de garantia só aceita valores inteiros");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}				
				
			}
		});
		btnSalvar.setBounds(531, 295, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o Curta*");
		lblDescricao.setBounds(10, 29, 98, 14);
		contentPane.add(lblDescricao);
		
		edtDescricaoCurta = new JTextField();
		edtDescricaoCurta.setBounds(10, 55, 312, 20);
		contentPane.add(edtDescricaoCurta);
		edtDescricaoCurta.setColumns(10);			
		
		JLabel lblEspecificacoes = new JLabel("Especifica\u00E7\u00F5es");
		lblEspecificacoes.setBounds(10, 86, 98, 14);
		contentPane.add(lblEspecificacoes);
		
		jtaEspecificacoes = new JTextArea();
		jtaEspecificacoes.setBounds(10, 109, 610, 175);
		contentPane.add(jtaEspecificacoes);
		
		JLabel lblGarantia = new JLabel("Garantia*");
		lblGarantia.setBounds(332, 29, 86, 14);
		contentPane.add(lblGarantia);
		
		edtGarantia = new JTextField();
		edtGarantia.setBounds(332, 55, 86, 20);
		contentPane.add(edtGarantia);
		edtGarantia.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status*");
		lblStatus.setBounds(430, 29, 86, 14);
		contentPane.add(lblStatus);
		
		cbStatus = new JComboBox<>();
		cbStatus.addItem("Selecione...");
		cbStatus.addItem("Recebido");
		cbStatus.addItem("Entregue");
		cbStatus.setSelectedIndex(1);
		cbStatus.setEnabled(false);
		cbStatus.setBounds(430, 54, 190, 22);
		contentPane.add(cbStatus);

	}
	
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
		this.edtDescricaoCurta.setText(equipamento.getDescricaoCurta());
		this.edtGarantia.setText(String.valueOf(equipamento.getGarantia()));
		this.jtaEspecificacoes.setText(equipamento.getEspecificacoes());
		if (equipamento.getStatus() == Status.R) {
			this.cbStatus.setSelectedIndex(1);
			this.cbStatus.setEnabled(true);
		}else if (equipamento.getStatus() == Status.E) {
			this.cbStatus.setSelectedIndex(2);
			this.cbStatus.setEnabled(false);
		}		
	}
}
