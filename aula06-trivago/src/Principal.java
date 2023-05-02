
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Single quartoSingle = new Single(1, "Quarto mais em conta", 100);
		
		SuiteLuxo quartoSuiteLuxo = new SuiteLuxo(2, "Quarto melhorzin", 220);
		
		LuxoDuplo quartoLuxoDuplo = new LuxoDuplo(3, "Quarto topzera", 350);
		
		CalculadoraDeDiarias calculadora = new CalculadoraDeDiarias();
		calculadora.registrar(quartoSingle);
		calculadora.registrar(quartoSuiteLuxo);
		calculadora.registrar(quartoLuxoDuplo);
		
		Relatorio relatorioDeDiarias = calculadora.gerarRelatorio();
		apresentar(relatorioDeDiarias);
		
	}

	private static void apresentar(Relatorio relatorio) {
		
		System.out.println("Total Geral: R$" + relatorio.getTotalGeral());
		System.out.println("Total Single: R$" + relatorio.getTotalSingle());
		System.out.println("Total Suite Luxo: R$" + relatorio.getTotalSuiteLuxo());
		System.out.println("Total Luxo Duplo: R$" + relatorio.getTotalLuxoDuplo());
		
	}
	
}
