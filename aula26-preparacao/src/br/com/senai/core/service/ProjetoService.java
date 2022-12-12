package br.com.senai.core.service;

import java.time.LocalDate;
import java.util.List;

import br.com.senai.core.dao.DaoProjeto;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Projeto;
import br.com.senai.core.domain.Status;

public class ProjetoService {	
	
	private DaoProjeto dao;
	
	public ProjetoService() {
		this.dao = FactoryDao.getInstance().getDaoProjeto();
	}
	
	public void salvar(Projeto projeto) {
		
		this.validar(projeto);
		
		LocalDate dataDeFim = gerarDataFinalPor(
				projeto.getDataDeInicio(), projeto.getPrazo());
		
		projeto.setDataDeFim(dataDeFim);
		
		boolean isPersistido = projeto.getId() > 0;
		
		if (isPersistido) {
			this.dao.alterar(projeto);
		}else {
			this.dao.inserir(projeto);
		}
		
	}
	
	public LocalDate gerarDataFinalPor(LocalDate dataDeInicio, int prazo) {
		
		boolean isDataDeInicioInvalida = dataDeInicio == null
				||  dataDeInicio.isBefore(LocalDate.now());
		
		if (isDataDeInicioInvalida) {
			throw new IllegalArgumentException("A data de início do projeto "
					+ "é obrigatório e deve ser posterior a data atual");
		}
		
		boolean isPrazoInvalido = prazo <= 0;
		
		if (isPrazoInvalido) {
			throw new IllegalArgumentException("O prazo do projeto deve ser maior que zero");
		}
		
		LocalDate dataFinal = dataDeInicio.plusDays(prazo);
		
		return dataFinal;
	}
	
	private void validar(Projeto projeto) {
		if (projeto != null) {
			
			boolean isDescricaoInvalida = projeto.getDescricaoCurta() == null 
					|| projeto.getDescricaoCurta().isBlank() 
					|| projeto.getDescricaoCurta().length() < 3 
					|| projeto.getDescricaoCurta().length() > 150;
			
			if (isDescricaoInvalida) {
				throw new IllegalArgumentException("A descrição curta é obrigatória "
						+ "e deve possuir entre 3 e 150 caracteres");
			}		
					
			boolean isDetalhamentoInvalido = projeto.getDetalhamento() == null
					|| projeto.getDetalhamento().isBlank();
			
			if (isDetalhamentoInvalido) {
				throw new IllegalArgumentException("O detalhamento do projeto é obrigatório");
			}
			
			boolean isValorInvalido = projeto.getValor() <= 0;
			
			if (isValorInvalido) {
				throw new IllegalArgumentException("O valor do projeto deve ser maior que zero");
			}					
			
			boolean isStatusInvalido = projeto.getStatus() == null;
			
			if (isStatusInvalido) {
				throw new IllegalArgumentException("O status do projeto é obrigatório");
			}
			
			boolean isAtivoInvalido = projeto.getAtivo() == null;
			
			if (isAtivoInvalido) {
				throw new IllegalArgumentException("O indicador de ativação/inativação "
						+ "do projeto é obrigatório");
			}
			
			boolean isJaPersistido = projeto.getId() > 0;
			
			if (isJaPersistido) {
				Projeto projetoJaSalvo = dao.buscarPor(projeto.getId());
				boolean isAlteracaoInvalida = projeto.getStatus() != Status.F 
						&& projeto.getStatus() != Status.C 
						&& (projetoJaSalvo.getStatus() == Status.F
						|| projetoJaSalvo.getStatus() == Status.C);
				if (isAlteracaoInvalida) {
					throw new IllegalArgumentException("O status do projeto não pode ser "
							+ "alterado após ele sido salvo com status 'F' ou 'C'");
				}
			}
					
		}else {
			throw new NullPointerException("O projeto não pode ser nulo");
		}
	}
	
	public void removerPor(int idDoProjeto) {
		if (idDoProjeto > 0) {
			this.dao.excluirPor(idDoProjeto);
		}else {
			throw new IllegalArgumentException("O id para remoção do projeto deve ser maior que zero");
		}
	}
	
	public List<Projeto> listarPor(String descricao){
		if (descricao != null && !descricao.isBlank()) {
			String filtro = descricao + "%";
			return dao.listarPor(filtro);		
		}else {
			throw new IllegalArgumentException("O filtro para listagem é obrigatório");
		}
	}

}
