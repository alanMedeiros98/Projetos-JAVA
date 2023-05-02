package br.com.senai;

import br.com.senai.domain.Aluno;
import br.com.senai.util.BaseDeDados;

public class Principal {

	public static void main(String[] args) {
		
		BaseDeDados base = new BaseDeDados();
		
		/*Aluno aluno = new Aluno(1, "Laudelino Neto", 
				"Maria Antioneta", "Programação para Internet");

		base.inserir(aluno);
		
		aluno = new Aluno(2, "Maria Joaquina", 
				"Antonia da Silva", "Finanças");
		
		base.inserir(aluno);*/
		
		for (Aluno aluno : base.getAlunos()) {
			System.out.println(aluno.getCodigo() + " - " + aluno.getNomeCompleto()			);
		}
		
		System.out.println("Programa foi finalizado");
		
	}

}
