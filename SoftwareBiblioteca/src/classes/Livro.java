package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Livro {

	private static Integer proximoId = 1;
	private Integer id;
	private String titulo; 
	private String genero;
	private String autor;
	private Integer ano;
	private Boolean alugado = false;
	
	public Livro() {
	
	}

	public Livro(Integer id, String titulo, String genero, String autor, Integer ano, Boolean alugado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.ano = ano;
		this.alugado = alugado;
	}

	public static Integer getProximoId() {
		return proximoId++;
	}

	public static void setProximoId(Integer proximoId) {
		Livro.proximoId = proximoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public Boolean getAlugado() {
		return alugado;
	}

	public void setAlugado(Boolean alugado) {
		this.alugado = alugado;
	}

	public String toString() {
		return "ID: " + id + " | Titulo: " + titulo+ " | Genêro: " + genero + " | Autor: " + autor + " | Ano: " + ano + " | Alugado: " + (alugado ? "Alugado" : "Livre");
	}

	public Livro cadastrar (String titulo, String autor, String genero, Integer ano) {
	
		this.setId(getProximoId());
		this.setTitulo(titulo);
		this.setGenero(genero);
		this.setAutor(autor);
		this.setAno(ano);
		
		return this;
		
	}
	
	public Livro alterar (Integer id, String titulo, String autor, String genero, Integer ano) {
		
		this.setId(id);
		this.setTitulo(titulo);
		this.setGenero(genero);
		this.setAutor(autor);
		this.setAno(ano);
		
		return this;
	}
	
	public void remover (Integer id) {
		
		ArrayList<Livro> livros = new ArrayList<Livro>();
		for (int i = 0; i < livros.size(); i++) {
			if (id.equals(livros.get(i).getId())) {
				livros.remove(livros.get(i));
				
			}
		}
		
	}
	
public  Livro consultarPorId(ArrayList<Livro> livros, Integer id) {
		
		for (Livro livro : livros) {
			if(livro.getId().equals(id)) {
				return livro;
			}
		}
		return null;
	}
	
}
