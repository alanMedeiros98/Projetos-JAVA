package br.com.senai.domain;

import java.util.Objects;

public class Ornitorrinco {
	
	private int id;
	
	private String nome;
	
	private boolean isAtivo;
	
	private TipoDeConvenio tipoDeConvenio;
	
	private Sexo sexo;

	public Ornitorrinco(String nome, boolean isAtivo, 
			TipoDeConvenio tipoDeConvenio, Sexo sexo) {	
		this.nome = nome;
		this.isAtivo = isAtivo;
		this.tipoDeConvenio = tipoDeConvenio;
		this.sexo = sexo;
	}

	public Ornitorrinco(int id, String nome, boolean isAtivo, 
			TipoDeConvenio tipoDeConvenio, Sexo sexo) {
		this(nome, isAtivo, tipoDeConvenio, sexo);
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
		this.nome = nome;
	}

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public TipoDeConvenio getTipoDeConvenio() {
		return tipoDeConvenio;
	}

	public void setTipoDeConvenio(TipoDeConvenio tipoDeConvenio) {
		this.tipoDeConvenio = tipoDeConvenio;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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
		Ornitorrinco other = (Ornitorrinco) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Ornitorrinco [id=" + id + ", nome=" + nome 
				+ ", isAtivo=" + isAtivo + ", tipoDeConvenio="
				+ tipoDeConvenio + ", sexo=" + sexo + "]";
	}	
	
}
