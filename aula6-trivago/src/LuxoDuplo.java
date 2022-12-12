
public class LuxoDuplo extends Quarto{

	private final double DESCONTO_CONCEDIDO = 0.1;
	
	public LuxoDuplo(int codigo, String descricao, double valorDiaria) {
		super(codigo, descricao, valorDiaria);
	}
	
	public double aplicarDesconto() {
		double diariaComDesconto = getValorDiaria() - (getValorDiaria() * DESCONTO_CONCEDIDO);
		return diariaComDesconto;
	}
	
}
