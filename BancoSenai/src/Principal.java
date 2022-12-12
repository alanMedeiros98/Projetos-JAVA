
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gerente gerente = new Gerente();
		gerente.setNome("Luis");
		gerente.setQtdeDeSubordinados(10);
		gerente.setSalario(35000);
		double bonificacao = gerente.getBonificacao();
		System.out.println("Bonus ganho: " + bonificacao);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Renam");
		funcionario.setSalario(1500);
		bonificacao = funcionario.getBonificacao();
		System.out.println("Bonus ganho: " + bonificacao);
		
	}

}
