package br.com.senai.domain;

import java.io.Serializable;

public class Video implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String titulo;
	
	private String descricaoCurta;
	
	private String url;
	
	private double duracao;
	
	private Formato formato;
	
	public Video(String titulo, String descricaoCurta, String url, double duracao, Formato formato) {		
		this.titulo = titulo;
		this.descricaoCurta = descricaoCurta;
		this.url = url;
		this.duracao = duracao;
		this.formato = formato;
	}

	public Video(int id, String titulo, String descricaoCurta, String url, double duracao, Formato formato) {
		this(titulo, descricaoCurta, url, duracao, formato);
		this.id = id;		
	}
	
	public Video(String linha) {
		if (linha != null) {
			String[] campos = linha.split(";");
			this.setId(Integer.parseInt(campos[0]));
			this.setTitulo(campos[1]);
			this.setDescricaoCurta(campos[2]);
			this.setUrl(campos[3]);
			this.setDuracao(Double.parseDouble(campos[4]));
			
			//O método .valueOf retorna o enum a partir do nome salvo no arquivo
			Formato formato = Formato.valueOf(campos[5]);
			this.setFormato(formato);
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

	public String getDescricaoCurta() {
		return descricaoCurta;
	}

	public void setDescricaoCurta(String descricaoCurta) {
		this.descricaoCurta = descricaoCurta;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	@Override
	public String toString() {
		return getId() + ";" + getTitulo() + ";" + getDescricaoCurta() 
				+ ";" + getUrl() + ";" + getDuracao() + ";" + getFormato() + "\n";
	}
	
}
