package br.com.senai.pojo;

import br.com.senai.excecoes.CampoInvalidoException;
import br.com.senai.excecoes.CampoObrigatorioException;

public abstract class Participante {

	private final int MIN_LENGTH_NOME = 3,
			          LENGHT_CPF = 11;
	
	private int id;
	
	private String nomeCompleto;
	
	private String cpf;

	public Participante(int id, String nomeCompleto, String cpf) {	
		this.setId(id);
		this.setNomeCompleto(nomeCompleto);
		this.setCpf(cpf);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		
		//O id não pode ser menor ou igual a zero
		if (id > 0) {		
			this.id = id;
		}else {
			throw new CampoInvalidoException("O id não pode ser menor que zero");
		}
		
	}

	public String getNomeCompleto() {		
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		
		//Verifica se o nome foi preenchido		
		if (nomeCompleto != null && !nomeCompleto.isEmpty()) {
			
			//Verifica se o nome possui o minimo de caracteres
			if (nomeCompleto.length() >= MIN_LENGTH_NOME) {			
				this.nomeCompleto = nomeCompleto;
			}else {
				throw new CampoInvalidoException("O nome completo deve possui mais de 3 caracteres");
			}
			
		}else {
			throw new CampoObrigatorioException("O nome completo é obrigatório");
		}
		
	}

	public String getCpf() {		
		return cpf;
	}

	public void setCpf(String cpf) {
		
		//Verifica se o cpf foi preenchido		
		if (cpf != null && !cpf.isEmpty()) {
							
			//Verifica se o cpf possui a quantidade exata de caracteres
			if (cpf.length() == LENGHT_CPF) {			
				this.cpf = cpf;
			}else {
				throw new CampoInvalidoException("O cpf deve possuir 11 caracteres e não possuir máscara");
			}
							
		}else {
			throw new CampoObrigatorioException("O cpf é obrigatório");
		}		

	}	
	
}
