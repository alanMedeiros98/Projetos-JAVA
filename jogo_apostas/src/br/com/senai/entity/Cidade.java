package br.com.senai.entity;

import br.com.senai.execessoes.NomeObrigatorio;

public class Cidade {

	private int id;
	private String nome;
	private String uf;

	public Cidade(String nome, String uf) {
		this.nome = nome;
		this.uf = uf;
	}

	public Cidade(int id, String nome, String uf) {
		this(nome, uf);
		this.id = id;

	}

	public Cidade() {
		this(0, "", "");

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.equals("") && nome.matches("[a-zA-Z/s ]+")) {
			this.nome = nome.toUpperCase();
		} else {
			throw new NomeObrigatorio("O campo não pode ser vazio e deve receber somente letras!");
		}

	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {

		if (uf != null && !uf.equals("") && uf.matches("[a-zA-Z/s ]+") && uf.length() <= 2) {
			this.uf = uf.toUpperCase();
		} else {
			throw new NomeObrigatorio("O campo não pode ser vazio e deve receber somente duas letras!");
		}

	}

	@Override
	public String toString() {
		return nome + " " + uf;
	}
	
	

}
