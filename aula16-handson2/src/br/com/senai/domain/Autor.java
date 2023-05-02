package br.com.senai.domain;

import java.io.Serializable;
import java.util.Objects;

public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String nomeCompleto;
	
	private String nacionalidade;
	
	public Autor(String nomeCompleto, String nacionalidade) {
		this.nomeCompleto = nomeCompleto;
		this.nacionalidade = nacionalidade;
	}

	public Autor(int id, String nomeCompleto, String nacionalidade) {
		this(nomeCompleto, nacionalidade);
		this.id = id;
	}
	
	public Autor(String linha) {
		String[] campos = linha.split(";");
		this.setId(Integer.parseInt(campos[0]));
		this.setNomeCompleto(campos[1]);
		this.setNacionalidade(campos[2]);
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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
		Autor other = (Autor) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return getId() + "," + getNomeCompleto() + "," + getNacionalidade();
	}	

}
