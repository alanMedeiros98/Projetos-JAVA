
public class Gerente extends Funcionario{	
	
	
	private int qtdeDeSubordinados;
	
	public Gerente() {
		
	}

	public int getQtdeDeSubordinados() {
		return qtdeDeSubordinados;
	}

	public void setQtdeDeSubordinados(int qtdeDeSubordinados) {
		this.qtdeDeSubordinados = qtdeDeSubordinados;
	}

	public boolean autenticar(int senhaInformada) {
		return true;
	}
	
	public double getBonificacao() {
		return getBonificacao() + 1000;
	}
	
	public void promover() {
		System.out.println("Gerente promovido!!");
	}
	
}
