
public class Gerente extends Funcionario {

	private int senha;
	private int qtdeDeSubordinados;
	
	public Gerente() {
		
	}
	
	
	
	public int getSenha() {
		return senha;
	}



	public void setSenha(int senha) {
		this.senha = senha;
	}



	public int getQtdeDeSubordinados() {
		return qtdeDeSubordinados;
	}



	public void setQtdeDeSubordinados(int qtdeDeSubordinados) {
		this.qtdeDeSubordinados = qtdeDeSubordinados;
	}



	public boolean autenticar(int senhaInformada) {
		if(this.senha == senhaInformada) {
			System.out.println("Acesso permitido!");
			return true;
		}else {
			System.out.println("Acesso negado!");
			return false;
		}
	}
	
	public double getBonificacao() {
		return super.getBonificacao() + 1000;
	}
	
}
