
public class Principal {

	public static void main(String[] args) {
		
		GeradorDeFuncionarios gerador = new GeradorDeFuncionarios();
		
		Funcionario gerente = gerador.criarPor(GeradorDeFuncionarios.TIPO_GERENTE);
		gerente.setNome("Laudelino Neto");
		gerente.setSalario(35000);		
		
		Funcionario gerente1 = gerador.criarPor(GeradorDeFuncionarios.TIPO_GERENTE);
		gerente1.setNome("Renan Calheiros");
		gerente1.setSalario(2500);		
		
		Funcionario supervisor = gerador.criarPor(GeradorDeFuncionarios.TIPO_SUPERVISOR);
		supervisor.setNome("Michel Temer");
		supervisor.setSalario(5000);
		
		Funcionario supervisor1 = gerador.criarPor(GeradorDeFuncionarios.TIPO_SUPERVISOR);
		supervisor1.setNome("Tarcisio Gomes");
		supervisor1.setSalario(1500);		
		
		ControleDeBonificacoes controle = new ControleDeBonificacoes();
		controle.registrar(gerente);
		controle.registrar(gerente1);
		controle.registrar(supervisor);
		controle.registrar(supervisor1);
		
		SistemaInterno sistema = new SistemaInterno();
		sistema.autorizarAcessoDo(supervisor);
		sistema.autorizarAcessoDo(supervisor1);
		sistema.autorizarAcessoDo(gerente);
		
		System.out.println(controle.getTotalDeBonificacoes());
		
		

	}

}
