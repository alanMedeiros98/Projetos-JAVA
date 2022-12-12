package br.com.senai.core.domain;

import java.util.Objects;

public class Aluno {
	
	private int id;
	
	private String nomeCompleto;
	
	private String cpf;

	public Aluno(String nomeCompleto, String cpf) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
	}
	
	public Aluno(int id, String nomeCompleto, String cpf) {
		this(nomeCompleto, cpf);
		this.id = id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		Aluno other = (Aluno) obj;
		return id == other.id;
	}		
	
}
