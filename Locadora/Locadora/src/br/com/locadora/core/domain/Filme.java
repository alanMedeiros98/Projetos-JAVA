package br.com.locadora.core.domain;

import java.util.ArrayList;

public class Filme {

	ArrayList<Filme> filmes = new ArrayList<Filme>();
	private static Integer idFilme;
	private String nome;
	private String genero;
	private String dataLancamento;
	private String posiEst;
	
	public Filme() {
		
	}

	public Filme(String nome, String genero, String dataLancamento, String posiEst) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.dataLancamento = dataLancamento;
		this.posiEst = posiEst;
	}

	public static Integer getIdFilme() {
		return idFilme;
	}

	public static void setIdFilme(Integer idFilme) {
		Filme.idFilme = idFilme;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getPosiEst() {
		return posiEst;
	}

	public void setPosiEst(String posiEst) {
		this.posiEst = posiEst;
	}

	@Override
	public String toString() {
		return "Filme [nome=" + nome + ", genero=" + genero + ", dataLancamento=" + dataLancamento + ", posiEst="
				+ posiEst + "]";
	}
	
	
	
}
