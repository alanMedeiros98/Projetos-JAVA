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
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Aluno;
import br.com.senai.core.domain.UnidadeCurricular;
import br.com.senai.core.service.InscricaoService;
import br.com.senai.core.service.UnidadeCurricularService;
import br.com.senai.view.componentes.table.UnidadeTableModel;

public class ViewInscricao extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JLabel lblAlunoSelecionado;
	
	private JTable tableUnidades;
	
	private JComboBox<UnidadeCurricular> cbUnidades;
	
	private InscricaoService inscricaoService;
	
	private UnidadeCurricularService unidadeService;
	
	private Aluno alunoSelecionado;	

	public void setAluno(Aluno aluno) {
		this.alunoSelecionado = aluno;
		this.lblAlunoSelecionado.setText(lblAlunoSelecionado.getText() 
				+ aluno.getNomeCompleto() + " - " + aluno.getCpf());
	}
	
	public void carregarCombo() {
		List<UnidadeCurricular> unidades = unidadeService.listarTodas();
		for (UnidadeCurricular u : unidades) {
			cbUnidades.addItem(u);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ViewInscricao() {
		setResizable(false);
		setTitle("Inscrever Aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAlunoSelecionado = new JLabel("Aluno selecionado: ");
		lblAlunoSelecionado.setBounds(10, 11, 522, 14);
		contentPane.add(lblAlunoSelecionado);
		
		JLabel lblNewLabel = new JLabel("Unidades Curriculares");
		lblNewLabel.setBounds(10, 36, 201, 16);
		contentPane.add(lblNewLabel);
		
		cbUnidades = new JComboBox<UnidadeCurricular>();
		cbUnidades.setBounds(10, 63, 436, 25);
		contentPane.add(cbUnidades);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnidadeCurricular unidadeSelecionada = (UnidadeCurricular)cbUnidades.getSelectedItem();
				if (unidadeSelecionada != null) {
					UnidadeTableModel model = (UnidadeTableModel)tableUnidades.getModel();
					model.adicionar(unidadeSelecionada);
					tableUnidades.updateUI();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Selecione um unidade curricular");
				}
			}
		});
		btnAdicionar.setBounds(456, 62, 98, 26);
		contentPane.add(btnAdicionar);
		
		JLabel lblNewLabel_1 = new JLabel("Unidades Selecionadas");
		lblNewLabel_1.setBounds(10, 99, 164, 16);
		contentPane.add(lblNewLabel_1);
		
		this.tableUnidades = new JTable(new UnidadeTableModel(new ArrayList<UnidadeCurricular>()));
		JScrollPane spTable = new JScrollPane(tableUnidades);
		spTable.setBounds(10, 125, 544, 205);
		contentPane.add(spTable);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UnidadeTableModel model = (UnidadeTableModel)tableUnidades.getModel();
					List<UnidadeCurricular> unidadesSelecionadas = model.getUnidades();
					inscricaoService.gerarInscricoesPor(alunoSelecionado, unidadesSelecionadas);
					JOptionPane.showMessageDialog(contentPane, "Inscrições salvas com sucesso!");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnSalvar.setBounds(456, 341, 98, 26);
		contentPane.add(btnSalvar);
		
		setLocationRelativeTo(null);
		this.unidadeService = new UnidadeCurricularService();
		this.inscricaoService = new InscricaoService();
		this.carregarCombo();
	}
}
