package br.com.locadora.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.locadora.core.domain.Cliente;

public class ViewRelatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewRelatorio(ArrayList <Cliente> clientes) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 844, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTelaRelatorio = new JLabel("Tela de Relatórios");
		lblTelaRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaRelatorio.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
		
		JButton btnRelatrioDeCliente = new JButton("Relatório de Cliente");
		btnRelatrioDeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente relatorio = new Cliente();
			}
		});
		btnRelatrioDeCliente.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		
		JList list = new JList(clientes.toArray());
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRelatrioDeCliente, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(116)
							.addComponent(lblTelaRelatorio, GroupLayout.PREFERRED_SIZE, 578, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTelaRelatorio)
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRelatrioDeCliente, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
