package br.com.senai.excecoes;

public class LimiteAtingidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public LimiteAtingidoException(String mensagemDeErro) {
		super(mensagemDeErro);
	}
	
}
