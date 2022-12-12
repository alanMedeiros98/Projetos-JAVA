package br.com.senai.entity;

public class Aposta {

	private int id;
	private Pessoa pessoa;
	private Animal animal;
	private Corrida corrida;
	
	public Aposta() {
	
	}
	
	public Aposta(Pessoa pessoa, Animal animal, Corrida corrida) {
		this.pessoa = pessoa;
		this.animal = animal;
		this.corrida = corrida;
	}
	
	public Aposta(int id, Pessoa pessoa, Animal animal, Corrida corrida) {
		this(pessoa, animal, corrida);
		this.id =id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

	@Override
	public String toString() {
		return "Id: " + id + " | Pessoa: " + pessoa.getNome() + " | Animal: " + animal.getNome() + " | Nrº corrida: " + corrida.getId();
	}	
	
	
}
