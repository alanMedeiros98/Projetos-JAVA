package br.com.senai.domain;

import java.util.Objects;

public class Curso {

	private int id;
	private String descricaoCurta;
	
	public Curso(int id, String descricaoCurta) {
		this.id = id;
		this.descricaoCurta = descricaoCurta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricaoCurta() {
		return descricaoCurta;
	}
	public void setDescricaoCurta(String descricaoCurta) {
		this.descricaoCurta = descricaoCurta;
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
		Curso other = (Curso) obj;
		return id == other.id;
	}
	
	
	
}
