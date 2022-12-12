package br.com.senai.core.domain;

import java.util.Objects;

public class Equipamento {

	private int id;
	
	private String descricaoCurta;
	
	private String especificacoes;
	
	private int garantia;
	
	private Status status;
	
	public Equipamento(String descricaoCurta, String especificacoes, int garantia) {		
		this.descricaoCurta = descricaoCurta;
		this.especificacoes = especificacoes;
		this.garantia = garantia;
		this.status = Status.R;
	}

	public Equipamento(int id, String descricaoCurta, String especificacoes, 
			int garantia, Status status) {
		this(descricaoCurta, especificacoes, garantia);
		this.id = id;		
		this.status = status;
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

	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		Equipamento other = (Equipamento) obj;
		return id == other.id;
	}	
	
}
