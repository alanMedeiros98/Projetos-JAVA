
public class CalculadoraDeDiarias {
	
	private final int QTDE_MAX_REGISTROS = 100;

	private Quarto[] quartos;
	
	private int indice;
	
	public CalculadoraDeDiarias() {
		this.quartos = new Quarto[QTDE_MAX_REGISTROS];
	}
	
	public void registrar(Quarto quarto) {
		this.quartos[indice] = quarto;
		this.indice++;
	}
	
	public Relatorio gerarRelatorio() {
		
		double totalGeral = 0.0;
		
		double totalSingle = 0.0;
		
		double totalSuiteLuxo = 0.0;
		
		double totalLuxoDuplo = 0.0;
		
		for(Quarto quarto : quartos) {
			if(quarto != null) {
				totalGeral += quarto.aplicarDesconto();
				if(quarto instanceof Single) {
					totalSingle += quarto.aplicarDesconto();
				} else if(quarto instanceof SuiteLuxo) {
					totalSuiteLuxo += quarto.aplicarDesconto();
				}else if(quarto instanceof LuxoDuplo) {
					totalLuxoDuplo += quarto.aplicarDesconto();
			}
		}
		
		
	}
		Relatorio relatorio = new Relatorio(totalGeral, totalSingle, totalSuiteLuxo, totalLuxoDuplo);
		
		return relatorio;
	
}
}