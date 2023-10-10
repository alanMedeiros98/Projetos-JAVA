package br.com.senai.core.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogsAcesso {
	
	private int id;
	private LocalDateTime dataHora;
	private Usuario usuario;
	
	
	public LogsAcesso(int id, LocalDateTime dataHora, Usuario usuario) {
		this.id = id;
		this.dataHora = dataHora;
		this.usuario = usuario;
	}

	public LogsAcesso(LocalDateTime dataHora, Usuario usuario) {
		this.dataHora = dataHora;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Usuario getLogin() {
		return usuario;
	}

	public void setLogin(Usuario usuario) {
		this.usuario = usuario;
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
		LogsAcesso other = (LogsAcesso) obj;
		return id == other.id;
	}
	
	
	

}
