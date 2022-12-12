package br.com.senai.core.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Projeto {

	private int id;
	
	private String descricaoCurta;
	
	private String detalhamento;
	
	private int prazo;
	
	private double valor;
	
	private Status status;
	
	private Confirmacao ativo;
	
	private LocalDate dataDeInicio;
	
	private LocalDate dataDeFim;

	public Projeto(String descricaoCurta, String detalhamento, 
			int prazo, double valor, Status status,
			Confirmacao ativo, LocalDate dataDeInicio) {
		this.descricaoCurta = descricaoCurta;
		this.detalhamento = detalhamento;
		this.prazo = prazo;
		this.valor = valor;
		this.status = Status.N;
		this.ativo = ativo;
		this.dataDeInicio = dataDeInicio;		
	}	

	public Projeto(int id, String descricaoCurta, String detalhamento, 
			int prazo, double valor, Status status,
			Confirmacao ativo, LocalDate dataDeInicio, 
			LocalDate dataDeFim) {
		this(descricaoCurta, detalhamento, prazo, valor, status, 
				ativo, dataDeInicio);
		this.id = id;
		this.dataDeFim = dataDeFim;
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

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Confirmacao getAtivo() {
		return ativo;
	}

	public void setAtivo(Confirmacao ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(LocalDate dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public LocalDate getDataDeFim() {
		return dataDeFim;
	}

	public void setDataDeFim(LocalDate dataDeFim) {
		this.dataDeFim = dataDeFim;
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
		Projeto other = (Projeto) obj;
		return id == other.id;
	}
		
}
