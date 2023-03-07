package br.com.senai.excecoes;

public class CampoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CampoInvalidoException(String mensagemDeErro) {
		super(mensagemDeErro);
	}

}
