package br.com.senai.pojo;

import br.com.senai.excecoes.CampoInvalidoException;
import br.com.senai.excecoes.CampoObrigatorioException;
import br.com.senai.sistema.Registravel;

public class Fiscal extends Participante implements Registravel{

	private final int LENGHT_MATRICULA = 5;
	
	private String matricula;

	public Fiscal(int id, String nomeCompleto, String cpf, String matricula) {
		super(id, nomeCompleto, cpf);
		this.setMatricula(matricula);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		
		//Verifica se a matricula foi preenchida		
		if (matricula != null && !matricula.isEmpty()) {
									
			//Verifica se a matricula possui a quantidade exata de caracteres
			if (matricula.length() == LENGHT_MATRICULA) {			
				this.matricula = matricula;
			}else {
				throw new CampoInvalidoException("A matricula deve possuir 5 caracteres");
			}
									
		}else {
			throw new CampoObrigatorioException("A matricula é obrigatória");
		}

	}

	@Override
	public void apresentarHorarioDeEntrada() {
		System.out.println("O fiscal " + getNomeCompleto() + 
				" - Matricula: " + getMatricula() + " - Realizou entrada");
	}

}
