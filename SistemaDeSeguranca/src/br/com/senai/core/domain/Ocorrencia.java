package br.com.senai.core.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Ocorrencia {

	private int id;

	private LocalDate data;

	private String detalhamento;

	private Envolvido envolvido;

	private Incidente incidente;
	
	private Colaborador colaborador;
	
	
	public Ocorrencia() {
		
	}

	public Ocorrencia(LocalDate data, String detalhamento) {
		this.data = data;
		this.detalhamento = detalhamento;
	}
	
	public Ocorrencia(int id, LocalDate data, String detalhamento) {
		this.id = id;
		this.data = data;
		this.detalhamento = detalhamento;
	}

	public Ocorrencia(LocalDate data, String detalhamento, Envolvido envolvido,
			Incidente incidente, Colaborador colaborador) {
		this(data, detalhamento);
		this.envolvido = envolvido;
		this.incidente = incidente;
		this.colaborador = colaborador;
	}

	public Ocorrencia(int id, LocalDate data, String detalhamento, Envolvido envolvido,
			Incidente incidente, Colaborador colaborador) {
		this(data, detalhamento);
		this.envolvido = envolvido;
		this.incidente = incidente;
		this.colaborador = colaborador;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public Envolvido getEnvolvido() {
		return envolvido;
	}
	
	public void setEnvolvido(Envolvido envolvido) {
		this.envolvido = envolvido;;
	}
	
	public Incidente getIncidente() {
		return incidente;
	}
	
	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
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
		Ocorrencia other = (Ocorrencia) obj;
		return id == other.id;
	}


}