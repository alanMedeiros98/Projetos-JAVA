package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ViewCadastroDeOrnitorrinco extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField edtNome;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public ViewCadastroDeOrnitorrinco() {
		setResizable(false);
		setTitle("Cadastro de Ornitorrinco");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		edtNome = new JTextField();
		edtNome.setBounds(10, 29, 273, 20);
		contentPane.add(edtNome);
		edtNome.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(290, 11, 46, 14);
		contentPane.add(lblSexo);
		
		JComboBox cbSexo = new JComboBox();
		cbSexo.setBounds(290, 28, 134, 22);
		contentPane.add(cbSexo);
		
		JCheckBox chkAtivo = new JCheckBox("Ativo");
		chkAtivo.setSelected(true);
		chkAtivo.setBounds(10, 56, 97, 23);
		contentPane.add(chkAtivo);
		
		JPanel pnlConvenio = new JPanel();
		pnlConvenio.setBorder(new TitledBorder(null, "Tipo de Conv\u00EAnio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlConvenio.setBounds(10, 86, 160, 51);
		contentPane.add(pnlConvenio);
		pnlConvenio.setLayout(null);
		
		JRadioButton rdbParticular = new JRadioButton("Particular");
		buttonGroup.add(rdbParticular);
		rdbParticular.setBounds(6, 18, 71, 23);
		pnlConvenio.add(rdbParticular);
		
		JRadioButton rdbPublico = new JRadioButton("Público");
		buttonGroup.add(rdbPublico);
		rdbPublico.setBounds(85, 18, 69, 23);
		pnlConvenio.add(rdbPublico);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 138, 89, 23);
		contentPane.add(btnSalvar);
	}
}
