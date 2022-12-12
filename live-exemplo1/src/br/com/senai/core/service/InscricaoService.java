package br.com.senai.core.service;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoInscricao;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Aluno;
import br.com.senai.core.domain.Inscricao;
import br.com.senai.core.domain.UnidadeCurricular;

public class InscricaoService {
	
	private DaoInscricao dao;
	
	public InscricaoService() {
		this.dao = FactoryDao.getInstance().getDaoInscricao();
	}
	
	public void atualizarMediaPor(int idDoAluno, int idDaUnidade, double media) {
		if (idDoAluno > 0 && idDaUnidade > 0) {			
			boolean isMediaInvalida = media < 0 || media > 10;
			if (isMediaInvalida) {
				throw new IllegalArgumentException("A m�dia final deve estar entre 0 e 10");
			}			
			this.dao.atualizarPor(idDoAluno, idDaUnidade, media);
		}else {
			if (idDoAluno <= 0) {
				throw new IllegalArgumentException("O id do aluno para atualiza��o deve ser positivo");
			}else if (idDaUnidade <= 0){
				throw new IllegalArgumentException("O id da unidade para atualiza��o deve ser positivo");
			}
		}
	}
	
	public List<Inscricao> listarInscricoesPor(int idDoAluno){
		if (idDoAluno > 0) {		
			return dao.listarPor(idDoAluno);
		}
		throw new IllegalArgumentException("O id do aluno deve ser positivo");
	}
	
	public void removerInscricaoPor(int idDoAluno, int idDaUnidadeCurricular) {
		if (idDoAluno > 0 && idDaUnidadeCurricular > 0) {
			this.dao.excluirPor(idDoAluno, idDaUnidadeCurricular);
		}else {
			if (idDoAluno <= 0) {
				throw new IllegalArgumentException("O id do aluno para remo��o deve ser positivo");
			}else if (idDaUnidadeCurricular <= 0){
				throw new IllegalArgumentException("O id da unidade para remo��o deve ser positivo");
			}
		}
	}
	
	public void gerarInscricoesPor(Aluno aluno, List<UnidadeCurricular> unidadesCurriculares) {
		this.validar(aluno);
		this.validar(unidadesCurriculares);
		List<Inscricao> inscricoesDoAluno = new ArrayList<Inscricao>();
		for (UnidadeCurricular u : unidadesCurriculares) {
			Inscricao novaInscricao = new Inscricao(aluno, u);
			inscricoesDoAluno.add(novaInscricao);
		}
		this.dao.inserir(inscricoesDoAluno);
	}
	
	private void validar(List<UnidadeCurricular> unidadesCurriculares) {
		if (unidadesCurriculares != null) {
			boolean isListagemInvalida = unidadesCurriculares.isEmpty();
			if (isListagemInvalida) {
				throw new IllegalArgumentException("Deve existir pelo menos 1 unidade informada para inscri��o");
			}
			for (UnidadeCurricular u : unidadesCurriculares) {
				boolean isIdInvalido = u.getId() <= 0;
				if (isIdInvalido) {
					throw new IllegalArgumentException("A unidade curricular " + u.getDescricao() 
							+ " possui id inv�lido. Id encontrado: " + u.getId());
				}
				int qtdeDeOcorrencias = 0;
				for (UnidadeCurricular outraUnidade : unidadesCurriculares) {
					if (u.getId() == outraUnidade.getId()) {
						qtdeDeOcorrencias++;
					}
				}
				if (qtdeDeOcorrencias > 1) {
					throw new IllegalArgumentException("O id '" + u.getId() 
							+ "' est� presente em mais de uma ocorr�ncia na lista");
				}
			}
		}else {
			throw new NullPointerException("A listagem de unidades n�o pode ser nula");
		}
	}
	
	private void validar(Aluno aluno) {
		if (aluno != null) {
			boolean isIdInvalido = aluno.getId() <= 0;
			if (isIdInvalido) {
				throw new IllegalArgumentException("O id do aluno � obrigat�rio e deve ser positivo");
			}
		}else {
			throw new NullPointerException("O aluno n�o pode ser nulo");
		}
	}

}
