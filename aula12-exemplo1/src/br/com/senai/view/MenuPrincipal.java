package br.com.senai.view;

import javax.swing.JOptionPane;

import br.com.senai.dominio.Paciente;
import br.com.senai.dominio.Prontuario;
import br.com.senai.util.BaseDeDados;

public class MenuPrincipal {
	
	private BaseDeDados baseDeDados;

	public void iniciar() {
		
		int opcaoSelecionada = 0;
		
		String textoDoMenu = "1 - Cadastrar Paciente\n"
						   + "2 - Cadastrar Prontuário\n"
						   + "3 - Listar Paciente\n"
						   + "4 - Sair";
		
		Paciente paciente = new Paciente(1, "José da Silva", "12132133", "23133213131");
		this.baseDeDados.registrar(paciente);
		paciente = new Paciente(2, "José da Silva", "12132133", "23133213131");
		this.baseDeDados.registrar(paciente);
		
		do {
			try {
				opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(textoDoMenu));
				
				switch(opcaoSelecionada) {
				case 1:{
					this.cadastrarPaciente();
					break;
					}
				case 2:{
					this.cadastrarProntuario();
					break;
				}
				default:
					throw new IllegalArgumentException("ainda nao sei");
				}
			}catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(null, "A opção é inválida." + nfe.getMessage());
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			
		}while(opcaoSelecionada != 4);
		
	}
	
	private void cadastrarPaciente() {
		int id = 0;
		do {
			try {
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do paciente."));				
			}catch(NumberFormatException nfe) {
				id = 0;
			}
		}while(id == 0);
		try {
			String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo.");
			String rg = JOptionPane.showInputDialog("Digiteo RG.");
			String cpf = JOptionPane.showInputDialog("Digite o cpf.");
			Paciente novoPaciente = new Paciente(id, nomeCompleto, rg, cpf);
			this.baseDeDados.registrar(novoPaciente);
			JOptionPane.showMessageDialog(null, "Paciente Cadastrado com sucesso.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private Paciente selecionarPaciente() {
		Paciente[] pacientes = baseDeDados.listarRegistrados();
		String listagem = "";
		for(Paciente paciente : pacientes) {
			listagem += pacientes + "\n";
		}
		Paciente paciente = null;
		try {
			int idInformado = Integer.parseInt(JOptionPane.showInputDialog(listagem));
			paciente = baseDeDados.buscaPor(idInformado);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, nfe.getMessage());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return paciente;
		
	}
	
	
	private void cadastrarProntuario() {
		Paciente pacienteSelecionado = selecionarPaciente();
		try {
			double temperatura = Double.parseDouble(JOptionPane.showInputDialog("informe a temperatura"));
			int pressaoSistolica = Integer.parseInt(JOptionPane.showInputDialog("informe a pressao sistolica"));
			int pressaoDistolica = Integer.parseInt(JOptionPane.showInputDialog("informe a pressao distolica"));
			Prontuario prontuario = new Prontuario(temperatura, pressaoSistolica, pressaoDistolica);
			if(pacienteSelecionado != null) {
				pacienteSelecionado.setProntuario(prontuario);
				JOptionPane.showMessageDialog(null, "Prontuario registrado com sucesso.");
			}
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, nfe.getMessage());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
