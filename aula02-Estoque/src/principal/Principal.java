package principal;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Estoque estoqueDeTubarao = new Estoque(100);
		
		Estoque estoqueDeCriciuma = new Estoque(150);
		
		estoqueDeTubarao.transferirPara(estoqueDeCriciuma, 50);
		
		System.out.println(estoqueDeTubarao.getQuantidade());
		System.out.println(estoqueDeCriciuma.getQuantidade());
		
	}

}
