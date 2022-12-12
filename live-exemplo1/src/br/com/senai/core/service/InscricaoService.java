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
				throw new IllegalArgumentException("A média final deve estar entre 0 e 10");
			}			
			this.dao.atualizarPor(idDoAluno, idDaUnidade, media);
		}else {
			if (idDoAluno <= 0) {
				throw new IllegalArgumentException("O id do aluno para atualização deve ser positivo");
			}else if (idDaUnidade <= 0){
				throw new IllegalArgumentException("O id da unidade para atualização deve ser positivo");
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
				throw new IllegalArgumentException("O id do aluno para remoção deve ser positivo");
			}else if (idDaUnidadeCurricular <= 0){
				throw new IllegalArgumentException("O id da unidade para remoção deve ser positivo");
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
				throw new IllegalArgumentException("Deve existir pelo menos 1 unidade informada para inscrição");
			}
			for (UnidadeCurricular u : unidadesCurriculares) {
				boolean isIdInvalido = u.getId() <= 0;
				if (isIdInvalido) {
					throw new IllegalArgumentException("A unidade curricular " + u.getDescricao() 
							+ " possui id inválido. Id encontrado: " + u.getId());
				}
				int qtdeDeOcorrencias = 0;
				for (UnidadeCurricular outraUnidade : unidadesCurriculares) {
					if (u.getId() == outraUnidade.getId()) {
						qtdeDeOcorrencias++;
					}
				}
				if (qtdeDeOcorrencias > 1) {
					throw new IllegalArgumentException("O id '" + u.getId() 
							+ "' está presente em mais de uma ocorrência na lista");
				}
			}
		}else {
			throw new NullPointerException("A listagem de unidades não pode ser nula");
		}
	}
	
	private void validar(Aluno aluno) {
		if (aluno != null) {
			boolean isIdInvalido = aluno.getId() <= 0;
			if (isIdInvalido) {
				throw new IllegalArgumentException("O id do aluno é obrigatório e deve ser positivo");
			}
		}else {
			throw new NullPointerException("O aluno não pode ser nulo");
		}
	}

}
