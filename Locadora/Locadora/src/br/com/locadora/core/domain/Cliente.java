package br.com.locadora.core.domain;

import java.util.ArrayList;

public class Cliente {
	private static Integer proximoId = 1;
	private Integer id;
	private String nome;
	private Integer idade;
	private String cpf;
	private String endereco;
	
	
	public Cliente() {
		
	}

	public Cliente(Integer id ,String nome, Integer idade, String cpf, String endereco) {
		super();
		this.id = proximoId++;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public static Integer getProximoId() {
		return proximoId++;
	}

	public static void setProximoId(Integer proximoId) {
		Cliente.proximoId = proximoId;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", endereço=" + endereco + "]";
	}
	
	public Cliente cadastrar(String nome, Integer idade, String cpf, String endereco) {
		
		this.setNome(nome);
		this.setIdade(idade);
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setId(id);
		
		return this;
	}
	
	public String mostrarRelatorio(ArrayList<Cliente> clientes) {
		
		String txtRelatorio = "";
		for(Cliente cliente : clientes) {
			txtRelatorio += cliente;
		}
		
		return txtRelatorio;
	}
	
}













