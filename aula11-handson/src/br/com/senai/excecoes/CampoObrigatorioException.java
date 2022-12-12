package br.com.senai.excecoes;

public class CampoObrigatorioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CampoObrigatorioException(String mensagemDeErro) {
		super(mensagemDeErro);
	}
	
}
