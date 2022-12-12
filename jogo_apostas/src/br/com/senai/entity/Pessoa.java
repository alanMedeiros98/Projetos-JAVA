package br.com.senai.entity;

import javax.swing.JOptionPane;

import br.com.senai.execessoes.CidadeInvalida;
import br.com.senai.execessoes.IdadeInvalida;
import br.com.senai.execessoes.NomeObrigatorio;

public class Pessoa {

	private int id;
	private String nome;
	private Integer idade;
	private Cidade cidade;

	public Pessoa() {

	}

	public Pessoa(String nome, int idade, Cidade cidade) {
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
	}

	public Pessoa(int id, String nome, int idade, Cidade cidade) {
		this(nome, idade, cidade);
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
		if (nome != null && !nome.equals("") && nome.matches("[a-zA-Z/s ]+")) {
		this.nome = nome.toUpperCase();
	} else {
		throw new NomeObrigatorio("O campo não pode ser vazio e deve receber somente letras!");
	}
		}

	public int getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		if (idade != 0 && idade > 10 && idade < 100) {
			this.idade = idade;
			
		}else {
			throw new IdadeInvalida("Idade não pode ser vazia e nem menor que 10 ou maior que 100");
		}
		
		
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		if (cidade != null) {
			this.cidade = cidade;
		} else {
			throw new CidadeInvalida("Cidade invalida!");
			
		}
		
	}

	@Override
	public String toString() {
		return "Id: " + id + " | Nome: " + nome + " | Idade: " + idade + "| Cidade: " + cidade.getNome();
	}
	
	

}
