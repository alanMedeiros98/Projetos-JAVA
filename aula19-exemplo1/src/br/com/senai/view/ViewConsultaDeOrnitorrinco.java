package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.domain.Ornitorrinco;
import br.com.senai.domain.Sexo;
import br.com.senai.domain.TipoDeConvenio;
import br.com.senai.view.table.OrnitorrincoTableModel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewConsultaDeOrnitorrinco extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField edtNome;
	private JTable tabela;

	/**
	 * Create the frame.
	 */
	public ViewConsultaDeOrnitorrinco() {
		setResizable(false);
		setTitle("Consulta de Ornitorrinco");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		edtNome = new JTextField();
		edtNome.setBounds(10, 33, 340, 20);
		contentPane.add(edtNome);
		edtNome.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(360, 32, 64, 23);
		contentPane.add(btnListar);
		
		List<Ornitorrinco> ornitorrincos = new ArrayList<Ornitorrinco>();
		ornitorrincos.add(new Ornitorrinco(1, "Zezinho", true, TipoDeConvenio.PUBLICO, Sexo.MACHO));
		ornitorrincos.add(new Ornitorrinco(2, "Joaquim", true, TipoDeConvenio.PUBLICO, Sexo.MACHO));
		ornitorrincos.add(new Ornitorrinco(3, "Izolete", true, TipoDeConvenio.PUBLICO, Sexo.FEMEA));
		
		OrnitorrincoTableModel tableModel = new OrnitorrincoTableModel(ornitorrincos);		
		tabela = new JTable(tableModel);
		tabela.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 64, 414, 186);
		contentPane.add(scrollPane);
	}
}
