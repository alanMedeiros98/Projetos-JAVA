package br.com.senai.domain;

import java.util.Objects;

import javax.swing.JOptionPane;

public class Paciente {
	
	private int id;
	private String nomeCompleto;
	private int idade;
	private Tipo tipo;
	
	//Construtor
	
	
	public Paciente(String nomeCompleto, int idade, Tipo tipo) {
		this.setNomeCompleto(nomeCompleto);
		this.setIdade(idade);
		this.setTipo(tipo);
	}

	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		if (nomeCompleto.length() > 3 && nomeCompleto.length() < 150) {
			this.nomeCompleto = nomeCompleto;			
		} else {
			JOptionPane.showMessageDialog(null, "O nome precisa ter mais de 3 caracteres e menos que 150 caracteres");
		}
		
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade >= 18) {
			this.idade = idade;
		} else {
			JOptionPane.showMessageDialog(null, "O paciente precisa ser maior de idade.");
		}
		
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	//to string

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nomeCompleto=" + nomeCompleto + ", idade=" + idade + ", tipo=" + tipo
				+ "]";
	}

	//hash code and equals
	
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
		Paciente other = (Paciente) obj;
		return id == other.id;
	}
	
	
	
	
	

}
