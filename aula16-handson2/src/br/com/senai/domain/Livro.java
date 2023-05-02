package br.com.senai.domain;

import java.io.Serializable;
import java.util.Objects;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String titulo;
	
	private String subtitulo;
	
	private int qtdeDePaginas;
	
	private int anoDeLancamento;
	
	private Autor autor;
	
	public Livro(String titulo, String subtitulo, int qtdeDePaginas, int anoDeLancamento, Autor autor) {		
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.qtdeDePaginas = qtdeDePaginas;
		this.anoDeLancamento = anoDeLancamento;
		this.autor = autor;
	}

	public Livro(int id, String titulo, String subtitulo, int qtdeDePaginas, int anoDeLancamento, Autor autor) {
		this(titulo, subtitulo, qtdeDePaginas, anoDeLancamento, autor);
		this.id = id;		
	}
	
	public Livro(String linha) {
		if (linha != null) {
			/**
			 * formato da linha salva no arquivo:
			 *  id,titulo,subtitulo,qtdeDePaginas,anoDeLancamento;id,nomeCompleto,nacionalidade
			 *  Exemplo:
			 *  1,Use a Cabeça,Padrões de Projeto,450,2008;1,Cay Horstman,Americano
			 */
			String[] itens = linha.split(";");
			
			//A segunda posição do vetor possui os atributos do autor separados por ;
			Autor autor = new Autor(itens[1]);
			this.setAutor(autor);
			
			//Já a primeira posição é a posição dos campos do livro
			String[] campos = itens[0].split(";");
			this.setId(Integer.parseInt(campos[0]));
			this.setTitulo(campos[1]);
			this.setSubtitulo(campos[2]);
			this.setQtdeDePaginas(Integer.parseInt(campos[3]));
			this.setAnoDeLancamento(Integer.parseInt(campos[4]));
			
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public int getQtdeDePaginas() {
		return qtdeDePaginas;
	}

	public void setQtdeDePaginas(int qtdeDePaginas) {
		this.qtdeDePaginas = qtdeDePaginas;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return getId() + "," + getTitulo() + "," + getSubtitulo() + "," 
				+ getQtdeDePaginas() + "," + getAnoDeLancamento() 
				+ ";" + getAutor();
	}
	
	
	
}
