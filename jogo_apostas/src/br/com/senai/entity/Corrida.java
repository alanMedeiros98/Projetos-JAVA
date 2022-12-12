package br.com.senai.entity;

import java.util.Random;

import br.com.senai.service.CorridaService;

public class Corrida {

	private int id;
	private String sequencia;
	int vect[] = new int[3];
	public int total[] = new int [3];
	public int passos[] = new int [3];
	private int idAnimal;

	public Corrida() {

	}

	public Corrida(String sequencia) {
		this.sequencia = sequencia;
	}

	public Corrida(int id, String sequencia) {
		this(sequencia);
		this.id = id;

	}

	public String getSequencia() {
		return sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public int sorteio1() {
		Random r = new Random();
		int sorteio = r.nextInt(80);

		passos[0] = sorteio + vect[0];
		vect[0] = sorteio;
		total[0] += vect[0] + sorteio;
		System.out.println("Cavalo 01: " + total[0]);
		return passos[0];
	}

	public int sorteio2() {
		Random r = new Random();
		int sorteio = r.nextInt(80);

		passos[1] = sorteio + vect[1];
		vect[1] = sorteio;
		total[1] += vect[1] + sorteio;
		System.out.println("Cavalo 02: " + total[1]);
		
		return passos[1];
	}

	public int sorteio3() {
		Random r = new Random();
		int sorteio = r.nextInt(80);

		passos[2] = sorteio + vect[2];
		vect[2] = sorteio;
		total[2] += vect[2] + sorteio;
		System.out.println("Cavalo 03: " + total[2]);
		return passos[2];
	}
	

	@Override
	public String toString() {
		return "Corrida Nº " + id;
	}

}
