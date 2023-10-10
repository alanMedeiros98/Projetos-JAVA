package br.com.senai.view.ocorrencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.senai.core.domain.Colaborador;
import br.com.senai.core.domain.Envolvido;
import br.com.senai.core.domain.Incidente;
import br.com.senai.core.domain.Ocorrencia;
import br.com.senai.core.service.ColaboradorService;
import br.com.senai.core.service.EnvolvidoService;
import br.com.senai.core.service.IncidenteService;
import br.com.senai.core.service.OcorrenciaService;

public class ViewCadastroOcorrencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JFormattedTextField ftfDataOcorrencia;
	private JTextArea taDetalhamento;
	private OcorrenciaService ocorrenciaService;
	private EnvolvidoService envolvidoService;
	private IncidenteService incidenteService;
	private ColaboradorService colaboradorSerice;
	private JComboBox<Envolvido> cbEnvolvidos;
	private JComboBox<Colaborador> cbColaborador;
	private JComboBox<Incidente> cbIncidente;
	private Ocorrencia ocorrencia;

	public void carregarComboEnvolvidos() {
		List<Envolvido> envolvidos = envolvidoService.listarTodas();
		for (Envolvido en : envolvidos) {
			cbEnvolvidos.addItem(en);
		}
	}

	public void carregarComboIncidentes() {
		List<Incidente> incidentes = incidenteService.listarTodas();
		for (Incidente in : incidentes) {
			cbIncidente.addItem(in);
		}
	}

	public void carregarComboColaborador() {
		List<Colaborador> colaboradores = colaboradorSerice.listarTodas();
		for (Colaborador colab : colaboradores) {
			cbColaborador.addItem(colab);
		}
	}

	public ViewCadastroOcorrencia() {
		this.ocorrenciaService = new OcorrenciaService();
		setTitle("Gerenciar Ocorr\u00EAncia - Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnvolvido = new JLabel("Envolvido*");
		lblEnvolvido.setBounds(12, 43, 73, 16);
		contentPane.add(lblEnvolvido);

		cbEnvolvidos = new JComboBox<Envolvido>();
		cbEnvolvidos.setToolTipText("Selecione");

		cbEnvolvidos.setBounds(12, 64, 179, 25);
		contentPane.add(cbEnvolvidos);

		JLabel lblColaborador = new JLabel("Colaborador*");
		lblColaborador.setBounds(12, 43, 73, 16);
		contentPane.add(cbEnvolvidos);

		cbColaborador = new JComboBox<Colaborador>();
		cbColaborador.setBounds(212, 64, 210, 25);
		contentPane.add(cbColaborador);

		JLabel lblIncidente = new JLabel("Incidente*");
		lblIncidente.setBounds(12, 102, 73, 16);
		contentPane.add(lblIncidente);

		cbIncidente = new JComboBox<Incidente>();
		cbIncidente.setToolTipText("Selecione");
		cbIncidente.setBounds(12, 131, 247, 25);
		contentPane.add(cbIncidente);

		JLabel lblData = new JLabel("Data*");
		lblData.setBounds(270, 102, 55, 16);
		contentPane.add(lblData);

		ftfDataOcorrencia = new JFormattedTextField();
		ftfDataOcorrencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					if (!ftfDataOcorrencia.getText().equals("  /  /    ")) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						@SuppressWarnings("unused")
						LocalDate dataDeOcorrencia = LocalDate.from(dtf.parse(ftfDataOcorrencia.getText()));
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		ftfDataOcorrencia.setBounds(271, 133, 151, 20);
		contentPane.add(ftfDataOcorrencia);

		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			mascara.install(ftfDataOcorrencia);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ftfDataOcorrencia.setText(dataAtual.format(data));

		JLabel lblDetalhamento = new JLabel("Detalhamento*");
		lblDetalhamento.setBounds(12, 169, 121, 16);
		contentPane.add(lblDetalhamento);

		taDetalhamento = new JTextArea();
		taDetalhamento.setLineWrap(true);
		taDetalhamento.setBounds(12, 195, 410, 115);
		contentPane.add(taDetalhamento);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Envolvido envolvido = (Envolvido) cbEnvolvidos.getSelectedItem();
					Incidente incidente = (Incidente) cbIncidente.getSelectedItem();
					Colaborador colaborador = (Colaborador) cbColaborador.getSelectedItem();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataOcorrencia = LocalDate.from(dtf.parse(ftfDataOcorrencia.getText()));
					String detalhamento = taDetalhamento.getText();

					if (detalhamento.isEmpty() || dataOcorrencia.equals(null)) {
						JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios!");
					} else {

						if (ocorrencia == null) {
							ocorrencia = new Ocorrencia(dataOcorrencia, detalhamento, envolvido, incidente,
									colaborador);
							ocorrenciaService.salvar(ocorrencia);
							JOptionPane.showMessageDialog(contentPane, "Ocorrencia inserida com sucesso!");
							cbEnvolvidos.setSelectedIndex(0);
							cbIncidente.setSelectedIndex(0);
							cbColaborador.setSelectedIndex(0);
							ftfDataOcorrencia.setText("");
							taDetalhamento.setText("");
							ocorrencia = null;

						} else {
							ocorrencia.setData(dataOcorrencia);
							ocorrencia.setDetalhamento(detalhamento);
							ocorrencia.setEnvolvido(envolvido);
							ocorrencia.setIncidente(incidente);
							ocorrencia.setColaborador(colaborador);
							ocorrenciaService.salvar(ocorrencia);
							JOptionPane.showMessageDialog(contentPane, "Ocorrencia alterada com sucesso!");
						}
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(contentPane, "O campo de data só aceita números.");

				} catch (DateTimeParseException dtpe) {
					JOptionPane.showMessageDialog(contentPane, "Digite a data.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
					if (ocorrencia.getId() <= 0) {
						ocorrencia = null;
					}
				}

			}
		});
		btnSalvar.setBounds(324, 317, 98, 26);
		contentPane.add(btnSalvar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(324, 13, 98, 26);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaOcorrencia view = new ViewConsultaOcorrencia();
				view.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnConsultar);

		JLabel lblColaborador_1 = new JLabel("Colaborador*");
		lblColaborador_1.setBounds(212, 44, 121, 16);
		contentPane.add(lblColaborador_1);

		setLocationRelativeTo(null);
		this.envolvidoService = new EnvolvidoService();
		this.incidenteService = new IncidenteService();
		this.colaboradorSerice = new ColaboradorService();
		this.carregarComboEnvolvidos();
		this.carregarComboIncidentes();
		this.carregarComboColaborador();
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
		this.cbEnvolvidos.setSelectedItem(ocorrencia.getEnvolvido());
		this.cbColaborador.setSelectedItem(ocorrencia.getColaborador());
		this.cbIncidente.setSelectedItem(ocorrencia.getIncidente());
		this.taDetalhamento.setText(ocorrencia.getDetalhamento());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = ocorrencia.getData().format(dtf);
		this.ftfDataOcorrencia.setText(data);

		if (ocorrencia.getId() > 0) {
			this.ftfDataOcorrencia.setEditable(false);
		}

	}

}
