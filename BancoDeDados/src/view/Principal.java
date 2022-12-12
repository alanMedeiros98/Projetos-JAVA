package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.Visitante;
import service.VisitanteService;

public class Principal {

	public static void main(String[] args) {

		VisitanteService service = new VisitanteService();
		
		int op = 0;
		
		do {
			op = escolheMenu();
			switch (op) {
			case 1:
				//Gravar no banco
				Visitante v = new Visitante();
				v.setNome(JOptionPane.showInputDialog("Nome do visitante."));
				v.setEmail(JOptionPane.showInputDialog("E-mail."));
				v.setTelefone(JOptionPane.showInputDialog("Telefone."));
				service.inserirVisitante(v);
				break;
			case 2:
				//Listar todos
				ArrayList<Visitante> lista = service.listaTodos();
				for(Visitante visitante : lista) {
					System.out.println(visitante);
				}
				break;
			case 3:
				//Buscar pelo nome
				String filtro = JOptionPane.showInputDialog("Qual filtro?");
				lista = service.listaPorNome(filtro);
				for (Visitante visitante : lista) {
					System.out.println(visitante);
					break;
				}
			}
		} while(op != 4);
		
	}
	
	public static int escolheMenu() {
		String menu = "1 - Cadastrar Visitante\n"
					+ "2 - Buscar todos\n"
					+ "3 - Buscar por nome\n\n"
					+ "4 - SAIR";
		
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
}
