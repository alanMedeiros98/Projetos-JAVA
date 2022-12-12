package br.com.senai.core.domain;

import java.time.LocalDateTime;

public class LogsAcesso {
	
	private int id;
	private LocalDateTime dataHora;
	private Login login;
	
	
	public LogsAcesso(int id, LocalDateTime dataHora, Login login) {
		this.id = id;
		this.dataHora = dataHora;
		this.login = login;
	}

	public LogsAcesso(LocalDateTime dataHora, Login login) {
		this.dataHora = dataHora;
		this.login = login;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	

}
