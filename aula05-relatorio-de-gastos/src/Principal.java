
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Professor professor = new Professor();
		professor.setNome("Fernando Haadad");
		professor.setSalario(11400);
		professor.setHorasAula(100);
		
		FuncionarioAdministrativo funcionario = new FuncionarioAdministrativo();
		funcionario.setNome("Marcio zanelato");
		funcionario.setSalario(2500);
		
		FuncionarioAdministrativo outrofuncionario = new FuncionarioAdministrativo();
		outrofuncionario.setNome("Marileine Garcia");
		outrofuncionario.setSalario(2000);
		
		RelatorioDeGastos relatorio = new RelatorioDeGastos();
		relatorio.registrar(professor);
		relatorio.registrar(funcionario);
		relatorio.registrar(outrofuncionario);
		
		relatorio.apresentar();
		
	}

}
