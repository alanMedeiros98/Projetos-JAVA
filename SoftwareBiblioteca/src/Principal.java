


import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Aluno;
import classes.DevolucaoLivro;
import classes.Livro;
import classes.AlugarLivro;
import telas.TlAlteracaoAlu;
import telas.TlCadastroAlu;
import telas.TlCadastroLivro;
import telas.TlInicial;
import telas.TlRelatorioAluno;
import telas.TlRelatorioLivro;


public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Aluno> alunos = new ArrayList<>();		
		ArrayList<Livro> livros = new ArrayList<>();		
		ArrayList<AlugarLivro> locacoes = new ArrayList<>();	
		ArrayList<DevolucaoLivro> devolucoes = new ArrayList<>();
					
		TlInicial telaInicial = new TlInicial(locacoes, alunos, livros, devolucoes);
		telaInicial.setVisible(true);				
		
	}

}
