package aula3Censo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Censo censo = new Censo();
		
		Pessoa mariscleide = new Pessoa();
		mariscleide.setSexo('F');
		mariscleide.setEmpregado(false);
		mariscleide.setIdade(40);
		
		censo.registrarPessoa(mariscleide);
		
		Pessoa jose = new Pessoa();
		jose.setSexo('M');
		jose.setEmpregado(true);
		jose.setRenda(6000);
		jose.setIdade(16);
		
		censo.registrarPessoa(jose);
		
		Pessoa antonieta = new Pessoa();
		antonieta.setSexo('F');
		antonieta.setEmpregado(true);
		antonieta.setRenda(1500);
		antonieta.setIdade(69);
		
		censo.registrarPessoa(antonieta);
		
		Pessoa enzo = new Pessoa();
		enzo.setSexo('M');
		enzo.setEmpregado(false);
		enzo.setIdade(2);
		
		censo.registrarPessoa(enzo);
		
		System.out.println("Qtde de Homens: " + censo.contarHomens());
		System.out.println("Qtde de Mulheres: " + censo.contarMulheres());
		System.out.println("Renda média: " + censo.calcularRendaMedia());
		ResumoDeIdades resumo = censo.resumoDeIdades();
		System.out.println("Crianças: " + resumo.getQtdeDeJovens()
						 + "\nJovem: " + resumo.getQtdeDeJovens()
						 + "\nAdultos: " + resumo.getQtdeDeAdultos()
						 + "\nIdosos: " + resumo.getQtdeDeIdosos());
		
	}

}
