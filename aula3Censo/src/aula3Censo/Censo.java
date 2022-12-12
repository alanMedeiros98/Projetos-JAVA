package aula3Censo;

public class Censo {

	private Pessoa[] populacao;
	
	private int indicePopulacional;
	
	public Censo() {
		this.populacao = new Pessoa[100];
		this.indicePopulacional = 0;
	}
	
	public void registrarPessoa(Pessoa pessoa) {
		this.populacao[indicePopulacional] = pessoa;
		this.indicePopulacional++;
	}
	
	public int contarHomens() {
		int qtde = 0;
		
		for(Pessoa pessoa : populacao) {
			if (pessoa != null) {
				boolean isHomem = pessoa.getSexo() == 'M';
				if (isHomem) {
					qtde++;
				}
			}
		}
		
		return qtde;
	}
	
	public int contarMulheres() {
		int qtde = 0;
		
		for(Pessoa pessoa : populacao) {
			if (pessoa != null) {
				boolean isMulher = pessoa.getSexo() == 'F';
				if (isMulher) {
					qtde++;
				}
			}
		}
		
		return qtde;
	}
	
	public ResumoDeIdades resumoDeIdades() {
		ResumoDeIdades resumo = new ResumoDeIdades();
		
		for (Pessoa pessoa : populacao) {
			if (pessoa != null) {
				boolean isCrianca = pessoa.getIdade() > 0
						&& pessoa.getIdade() <= 0;
				boolean isJovem = pessoa.getIdade() > 12
						&& pessoa.getIdade() <= 17;
				boolean isAdulto = pessoa.getIdade() > 17
						&& pessoa.getIdade() <= 65;
				boolean isIdoso = pessoa.getIdade() > 65;
				
				if(isCrianca) {
					resumo.setQtdeDeCriancas(resumo.getQtdeDeCriancas() + 1);
				}
				if(isJovem) {
					resumo.setQtdeDeJovens(resumo.getQtdeDeJovens() + 1);
				}
				if(isAdulto) {
					resumo.setQtdeDeAdultos(resumo.getQtdeDeAdultos() + 1);
				}
				if(isIdoso) {
					resumo.setQtdeDeIdosos(resumo.getQtdeDeIdosos() + 1);
				}
			}
		}
		
		return resumo;
	}
	
	public double calcularRendaMedia() {
		double media = 0;
		double totalDeRenda = 0;
		int qtdeDeEmpregados = 0;
		
		for (Pessoa pessoa : populacao) {
			
			if(pessoa != null) {
				if (pessoa.isEmpregado()) {
					totalDeRenda += pessoa.getRenda();
					qtdeDeEmpregados++;
				}
			}
			
		}
		
		media = totalDeRenda / qtdeDeEmpregados;
		
		return media;
	}
	
}














































