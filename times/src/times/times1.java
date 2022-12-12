package times;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class times1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> times = new ArrayList<String>();
		ArrayList<String> jogadoresnome = new ArrayList<String>();
		ArrayList<String> jogadorestime = new ArrayList<String>();
		int menu;
		do {
			//Menu
			menu = Integer.parseInt(JOptionPane.showInputDialog("Menu\n\n"
															  + "1 - Lista de times\n"
															  + "2 - Cadastro de times\n"
															  + "3 - Alterar time\n"
															  + "4 - Remover time\n\n"
															  + "5 - Lista de jogadores\n"
															  + "6 - Cadastro de jogadores\n"
															  + "7 - Alterar jogadores\n"
															  + "8- Remover jogadores\n\n"
															  + "0 - Sair"));
			
			//Montagem de lista Times
			String listatimes = "Times\n";
			for (int i = 0; i < times.size(); i++) {
				listatimes += "\n" + i + " - " + times.get(i);
			}
			
			//Montagem de lista Jogadores
			String listajogadores = "Jogadores nome\n";
			for (int i = 0; i < jogadoresnome.size(); i++) {
				listajogadores += "\n" + i + " - " + jogadoresnome.get(i) + " - " + times.get(Integer.parseInt(jogadorestime.get(i)));
			}
			
			// Listagem de times
			if(menu == 1) {
				JOptionPane.showMessageDialog(null, listatimes);
			}
			
			//Cadastro de times
			else if (menu == 2) {
				times.add(JOptionPane.showInputDialog("Cadastrar time"
													+ "\n\nNome do time:"));
				JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso!");
			} 
			
			//Altera��o de times
			else if (menu == 3) {
				int idAlteracao = Integer.parseInt(JOptionPane.showInputDialog("Alterar time"
																			 + "\n\n" + listatimes
						  													 + "\n\nIdentificador do time para altera��o:"));
				times.set(idAlteracao, JOptionPane.showInputDialog("Alterar time"
																 + "\n\n" + times.get(idAlteracao)
																 + "\nNome do time para altera��o:"));
				JOptionPane.showMessageDialog(null, "Time alterado com sucesso!");
			}
			
			//Remo��o de times
			else if (menu == 4) {
				times.remove(Integer.parseInt(JOptionPane.showInputDialog("Remover time\n\n"
																		+ "\n\n" + listatimes
																		+ "\n\nIdentificador do time para remo��o:")));
				JOptionPane.showMessageDialog(null, "Time removido com sucesso!");
			}
			
			// Listagem de jogadores
			if(menu == 5) {
				JOptionPane.showMessageDialog(null, listajogadores);
			} 
			
			//Cadastro de Jogadores
			else if (menu == 6) {
				jogadoresnome.add(JOptionPane.showInputDialog("Cadastro\nDigite o nome do jogador:"));
				jogadorestime.add(JOptionPane.showInputDialog("Cadastrar jogador:"
															  + "\n\n" + listatimes
															  + "\n\nIdentificador de time:"));
				JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso!");	
			} 

			
			//Altera��o de Jogadores
			else if (menu == 7) {
				int idJogadorAlteracao = Integer.parseInt(JOptionPane.showInputDialog("Alterar jogador"
																			 + "\n\n" + listajogadores
						  													 + "\n\nIdentificador do jogador para altera��o:"));
				jogadoresnome.set(idJogadorAlteracao, JOptionPane.showInputDialog("Alterar jogador"
																 + "\n\n" + jogadoresnome.get(idJogadorAlteracao)
																 + "\nNome do time para altera��o:"));
				JOptionPane.showMessageDialog(null, "Jogador alterado com sucesso!");
			}
			
			//Remo��o de jogadores
			else if (menu == 8) {
				jogadoresnome.remove(Integer.parseInt(JOptionPane.showInputDialog("Remover jogador\n\n"
																		+ "\n\n" + listajogadores
																		+ "\n\nIdentificador do jogador para remo��o:")));
				JOptionPane.showMessageDialog(null, "Jogador removido com sucesso!");
			}
		} while (menu != 0);
	}

}
