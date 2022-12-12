
public class Principal {

	public static void main(String[] args) {
		
		Cozinheiro cozinheiro =  new Cozinheiro();
		cozinheiro.setCodigo(1);
		cozinheiro.setNomeCompleto("Rodrigo Maia");
		
		Espaguete espaguete = new Espaguete();
		espaguete.setCodigo(1);
		espaguete.setDescricaoCurta("Espaguete dos brabo");
		espaguete.setNumero(8);
		espaguete.setTipo(Tipo.INTEGRAL);
		
		Penne penne = new Penne();
		penne.setCodigo(2);
		penne.setDescricaoCurta("Penne da democracia");
		penne.setGranularidade(Granularidade.FINA);
		penne.setTipo(Tipo.NORMAL);
		
		cozinheiro.preparar(espaguete);
		cozinheiro.preparar(penne);
		
		
		

	}

}
