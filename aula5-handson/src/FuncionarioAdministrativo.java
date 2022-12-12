
public class FuncionarioAdministrativo {

	private String nome;
	private double salario;
	
	public FuncionarioAdministrativo() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getGasto() {
		return salario;
	}
	
	public String getInfo() {
		return nome + " - " + salario;
	}
	
}
