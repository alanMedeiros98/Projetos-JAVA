package principal;

import classes.Livro;

public class Principal {

	public static void main(String[] args) {
		
		Livro livro = new Livro();
		
		livro.nome = "boson linux";
		livro.descricao = "livro sobre boson linux";
		livro.autor = "fabio dos reis";
		livro.isbn = "65465488";
		livro.preco = 45.90;
		livro.dataPub = "20/04/2017";
		
		livro.dadosLivro();
		
		
		
	}

}
