package br.com.senai;

import br.com.senai.domain.Autor;
import br.com.senai.domain.Livro;
import br.com.senai.util.BaseDeDados;

public class Principal {

	public static void main(String[] args) {
		
		BaseDeDados bd = new BaseDeDados();
		
		Autor primeiroAutor = new Autor(1, "Primeiro Autor", "Brasileiro");
		
		Autor segundoAutor = new Autor(2, "Segundo Autor", "Canadense");
		
		Livro primeiroLivro = new Livro(1, "Primeiro Livro", "Primeiro Subtitulo", 300, 1870, primeiroAutor);
		
		Livro segundoLivro = new Livro(2, "Segundo Livro", "Segundo Subtitulo", 350, 1990, segundoAutor);
		
		bd.inserir(primeiroLivro);
		
		bd.inserir(segundoLivro);		
		
		System.out.println(bd.getLivros());

	}

}
