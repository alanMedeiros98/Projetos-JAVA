package br.com.senai.sistema;

import br.com.senai.excecoes.LimiteAtingidoException;

public class SistemaDeRegistro {
	
	private final int QTDE_MAX_PARTICIPANTES = 50;
	
	private Registravel[] participantes;
	
	private int indice;
	
	public SistemaDeRegistro() {
		this.participantes = new Registravel[QTDE_MAX_PARTICIPANTES];		
	}
	
	public void registrar(Registravel participante) throws LimiteAtingidoException {
		if (indice < QTDE_MAX_PARTICIPANTES) {
			participante.apresentarHorarioDeEntrada();
			this.participantes[indice] = participante;
			this.indice++;			
		}else {
			throw new LimiteAtingidoException("O limite máximo de participantes foi atingido. São permitidos apenas " + QTDE_MAX_PARTICIPANTES + " participante(s)");
		}
	}

}
