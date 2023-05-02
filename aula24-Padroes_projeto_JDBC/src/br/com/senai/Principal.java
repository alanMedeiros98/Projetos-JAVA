package br.com.senai;

import java.util.List;

import br.com.senai.dao.DaoCurso;
import br.com.senai.dao.FactoryDao;
import br.com.senai.domain.Curso;

public class Principal {

	public static void main(String[] args) {
		
		//ManagerDB.getInstance().getConexao();
		
		FactoryDao fabrica = new FactoryDao();
		
		
		Curso curso = new Curso(0, "Matematica");
		
		DaoCurso dao = fabrica.getDaoCurso();
		
		dao.inserir(curso);
		
		List<Curso> cursos = dao.listarPor("a");
		
		for (Curso c : cursos) {
			System.out.println("Curso: " + c.getDescricaoCurta());
		}
		
		System.out.println("Programa finalizado");

	}

}
