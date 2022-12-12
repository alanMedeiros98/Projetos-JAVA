
public class ControleDeBonificacoes {

	private double totalDeBonificacoes;
	
	public void registrar(Funcionario funcionario) {
		this.totalDeBonificacoes += funcionario.getBonificacao();
		}
	
	public double getTotalDeBonificacoes() {
		return totalDeBonificacoes;
	}
	
}
