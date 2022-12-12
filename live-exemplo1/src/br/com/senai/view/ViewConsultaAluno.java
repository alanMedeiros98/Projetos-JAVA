package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Aluno;
import br.com.senai.core.service.AlunoService;
import br.com.senai.view.componentes.table.AlunoTableModel;

public class ViewConsultaAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField edtFiltro;
	private JTable tableAlunos;
	
	private AlunoService alunoService;

	/**
	 * Create the frame.
	 */
	public ViewConsultaAluno() {
		this.alunoService = new AlunoService();		
		setResizable(false);
		setTitle("Consultar Alunos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Aluno");
		lblNewLabel.setBounds(10, 11, 103, 14);
		contentPane.add(lblNewLabel);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(10, 36, 521, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String filtro = edtFiltro.getText();
					List<Aluno> alunosEncontrados = alunoService.listarPor(filtro);
					AlunoTableModel model = new AlunoTableModel(alunosEncontrados);
					tableAlunos.setModel(model);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnListar.setBounds(544, 33, 98, 26);
		contentPane.add(btnListar);
		
		this.tableAlunos = new JTable(new AlunoTableModel(new ArrayList<Aluno>()));
		JScrollPane spTable = new JScrollPane(tableAlunos);
		spTable.setBounds(13, 96, 629, 225);
		contentPane.add(spTable);
		
		JLabel lblNewLabel_1 = new JLabel("Resultados Encontrados");
		lblNewLabel_1.setBounds(10, 69, 144, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRealizarInscricao = new JButton("Realizar Inscri\u00E7\u00E3o");
		btnRealizarInscricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableAlunos.getSelectedRow();
				if (linhaSelecionada >= 0) {
					AlunoTableModel model = (AlunoTableModel)tableAlunos.getModel();
					Aluno alunoSelecionado = model.getPor(linhaSelecionada);
					ViewInscricao view = new ViewInscricao();
					view.setAluno(alunoSelecionado);
					view.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(contentPane, "Selecione um aluno para inscrição");
				}
			}
		});
		btnRealizarInscricao.setBounds(492, 332, 150, 26);
		contentPane.add(btnRealizarInscricao);
		
		JButton btnLancarNotas = new JButton("Lan\u00E7ar Notas");
		btnLancarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableAlunos.getSelectedRow();
				if (linhaSelecionada >= 0) {
					AlunoTableModel model = (AlunoTableModel)tableAlunos.getModel();
					Aluno alunoSelecionado = model.getPor(linhaSelecionada);
					ViewLanctoDeNotas view = new ViewLanctoDeNotas();
					view.setAluno(alunoSelecionado);
					view.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(contentPane, "Selecione um aluno para lançamento");
				}
			}
		});
		btnLancarNotas.setBounds(338, 332, 144, 26);
		contentPane.add(btnLancarNotas);	
		
		setLocationRelativeTo(null);
		
	}
}
