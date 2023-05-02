
public class Supervisor extends Funcionario{

	public double getBonificacao() {
		return getSalario() + 100;
	}

	public boolean autenticar(int senha) {
		return true;
	}

	public void promover() {
		System.out.println("Supervisor promovido!!");
	}
	
}
