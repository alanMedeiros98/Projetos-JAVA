package br.com.senai.core.domain;

import java.util.Objects;

public class Inscricao {
	
	private Aluno aluno;
	
	private UnidadeCurricular unidadeCurricular;
	
	private double mediaFinal;

	public Inscricao(Aluno aluno, UnidadeCurricular unidadeCurricular) {
		this.aluno = aluno;
		this.unidadeCurricular = unidadeCurricular;		
	}
	
	public Inscricao(Aluno aluno, UnidadeCurricular unidadeCurricular, double mediaFinal) {
		this(aluno, unidadeCurricular);
		this.mediaFinal = mediaFinal;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public UnidadeCurricular getUnidadeCurricular() {
		return unidadeCurricular;
	}

	public void setUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
		this.unidadeCurricular = unidadeCurricular;
	}

	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, unidadeCurricular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscricao other = (Inscricao) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(unidadeCurricular, other.unidadeCurricular);
	}	
	
	@Override
	public String toString() {
		return getUnidadeCurricular().getDescricao();
	}
	
}
