package br.com.senai.domain;

import java.util.Objects;

public class Aluno {
	
	private int codigo;
	
	private String nomeCompleto;
	
	private String nomeDaMae;
	
	private String nomeDoCurso;

	public Aluno(int codigo, String nomeCompleto, 
			String nomeDaMae, String nomeDoCurso) {		
		this.codigo = codigo;
		this.nomeCompleto = nomeCompleto;
		this.nomeDaMae = nomeDaMae;
		this.nomeDoCurso = nomeDoCurso;
	}
	
	public Aluno(String linha) {
		if (linha != null) {
			String[] campos = linha.split(";");
			this.setCodigo(Integer.parseInt(campos[0]));
			this.setNomeCompleto(campos[1]);
			this.setNomeDaMae(campos[2]);
			this.setNomeDoCurso(campos[3]);
		}		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public String getNomeDoCurso() {
		return nomeDoCurso;
	}

	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return codigo == other.codigo;
	}
	
	public String toString() {
		return codigo + ";" + nomeCompleto + ";" 
				+ nomeDaMae + ";" + nomeDoCurso + "\n";
	}

}
