package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Aluno;
import br.com.senai.core.domain.Inscricao;
import br.com.senai.core.service.InscricaoService;
import br.com.senai.view.componentes.table.InscricaoTableModel;

public class ViewLanctoDeNotas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTable tableInscricoes;
	
	private JTextField edtMedia;
	
	private JLabel lblAlunoSelecionado;
	
	private JComboBox<Inscricao> cbInscricoes;
	
	private InscricaoService inscricaoService;	
	
	private Aluno alunoSelecionado;	

	public void setAluno(Aluno aluno) {
		this.alunoSelecionado = aluno;
		this.lblAlunoSelecionado.setText(lblAlunoSelecionado.getText() 
				+ aluno.getNomeCompleto() + " - " + aluno.getCpf());
		this.carregarCombo();
	}

	private void carregarCombo() {
		List<Inscricao> inscricoesDoAluno = inscricaoService.listarInscricoesPor(alunoSelecionado.getId());
		for (Inscricao i : inscricoesDoAluno) {
			this.cbInscricoes.addItem(i);
		}
	}
	
	private double getMedia() {		
		try {
			return Double.parseDouble(edtMedia.getText());		
		}catch (Exception ex) {
			throw new IllegalArgumentException("O campo média só aceita valores numéricos");
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ViewLanctoDeNotas() {
		this.inscricaoService = new InscricaoService();
		setTitle("Lan\u00E7amento de Notas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAlunoSelecionado = new JLabel("Aluno selecionado: ");
		lblAlunoSelecionado.setBounds(10, 11, 612, 14);
		contentPane.add(lblAlunoSelecionado);
		
		JLabel lblNewLabel = new JLabel("Unidades Inscritas");
		lblNewLabel.setBounds(10, 37, 254, 16);
		contentPane.add(lblNewLabel);
		
		cbInscricoes = new JComboBox<Inscricao>();
		cbInscricoes.setBounds(10, 58, 376, 25);
		contentPane.add(cbInscricoes);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E9dia Final");
		lblNewLabel_1.setBounds(396, 37, 102, 16);
		contentPane.add(lblNewLabel_1);
		
		edtMedia = new JTextField();
		edtMedia.setBounds(398, 63, 114, 20);
		contentPane.add(edtMedia);
		edtMedia.setColumns(10);
		
		JButton btnLancar = new JButton("Lan\u00E7ar");
		btnLancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double media = getMedia();
					Inscricao inscricaoSelecionada = (Inscricao)cbInscricoes.getSelectedItem();
					inscricaoSelecionada.setMediaFinal(media);
					inscricaoService.atualizarMediaPor(alunoSelecionado.getId(), 
							inscricaoSelecionada.getUnidadeCurricular().getId(), media);
					InscricaoTableModel model = (InscricaoTableModel)tableInscricoes.getModel();
					model.adicionar(inscricaoSelecionada);
					tableInscricoes.updateUI();
					JOptionPane.showMessageDialog(contentPane, "Média lançada com sucesso");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnLancar.setBounds(524, 57, 98, 26);
		contentPane.add(btnLancar);
		
		InscricaoTableModel model = new InscricaoTableModel(new ArrayList<Inscricao>());
		tableInscricoes = new JTable(model);
		JScrollPane spTable = new JScrollPane(tableInscricoes);
		spTable.setBounds(10, 123, 613, 205);
		contentPane.add(spTable);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E9dias");
		lblNewLabel_2.setBounds(10, 95, 55, 16);
		contentPane.add(lblNewLabel_2);
		
		setLocationRelativeTo(null);		
	}
}
