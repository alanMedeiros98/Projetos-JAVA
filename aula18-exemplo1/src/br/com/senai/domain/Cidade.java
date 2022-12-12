package br.com.senai.domain;

import java.util.Objects;

public class Cidade {
	
	private int id;
	
	private String nome;
	
	private String uf;

	public Cidade(String nome, String uf) {
		this.setNome(nome);
		this.uf = uf;
	}

	public Cidade(int id, String nome, String uf) {
		this(nome, uf);
		this.id = id;		
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
		if (nome != null && !nome.isBlank()) {		
			this.nome = nome;
		}else {
			throw new IllegalArgumentException("O nome é obrigatório");
		}
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		Cidade other = (Cidade) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", uf=" + uf + "]";
	}
		
}
