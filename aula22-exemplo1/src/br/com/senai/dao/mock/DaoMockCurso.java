package br.com.senai.dao.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.dao.DaoCurso;
import br.com.senai.domain.Curso;

public class DaoMockCurso implements DaoCurso {

	private List<Curso> cursos;
	
	public DaoMockCurso() {
		this.cursos = new ArrayList<>();
	}
	
	@Override
	public void inserir(Curso curso) {
		this.cursos.add(curso);
	}

	@Override
	public void alterar(Curso curso) {

	}

	@Override
	public void excluirPor(int id) {

	}

	@Override
	public Curso buscarPor(int id) {		
		return cursos.get(0);
	}

	@Override
	public List<Curso> listarPor(String descricaoCurta) {
		return cursos;
	}

}
