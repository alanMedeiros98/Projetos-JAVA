package br.com.senai.pojo;

import br.com.senai.excecoes.CampoInvalidoException;
import br.com.senai.sistema.Registravel;

public class Estudante extends Participante implements Registravel{

	private final int NOTA_MINIMA = 0,
			          NOTA_MAXIMA = 10;
	
	private double nota;

	public Estudante(int id, String nomeCompleto, String cpf) {
		super(id, nomeCompleto, cpf);
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		
		if (nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA) {		
			this.nota = nota;
		}else {
			throw new CampoInvalidoException("A nota deve estar entre 0 e 10");
		}
		
	}

	@Override
	public void apresentarHorarioDeEntrada() {
		System.out.println("O estudante " + getNomeCompleto() + 
				" - Realizou entrada");
	}
		
}
