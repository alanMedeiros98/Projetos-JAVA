
public class RelatorioDeGastos {

	private int indice = 0;
	private FuncionarioAdministrativo[] funcionarios;
	
	public RelatorioDeGastos() {
		this.funcionarios = new FuncionarioAdministrativo[10];
	}
	
	public void registrar(FuncionarioAdministrativo funcionario) {
		this.funcionarios[indice] = funcionario;
	}

	public void apresentar() {
		for(FuncionarioAdministrativo func : funcionarios) {
			if(func != null) {
				System.out.println(func.getInfo());
				System.out.println("Gastos: " + func.getGasto());
				System.out.println("--------------------");
			}
		}
	}
	
}
